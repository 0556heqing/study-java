package com.heqing.java.multithreaded;

import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author heqing
 * @date 2021/7/8 18:21
 */
public class StudyFuture {

    private static Logger log = LoggerFactory.getLogger(StudyFuture.class);

    class Task implements Callable<String> {
        public String call() throws Exception {
            return "测试";
        }
    }

    /**
     * 执行线程任务，并获取返回结果。要么调用阻塞方法get()，要么轮询看isDone()是否为true，这两种方法都不是很好，因为主线程也会被迫等待。
     * @throws InterruptedException
     */
    @Test
    public void testFuture() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        // 定义任务:
        Callable<String> task = new Task();
        // 提交任务并获得Future:
        Future<String> future = executor.submit(task);
        // 从Future获取异步执行返回的结果:
        log.info("线程返回值 --> {}", future.get());
    }

    ConcurrentLinkedQueue<String> allResultQueue = new ConcurrentLinkedQueue<>();

    String testSupplyAsync(String str) {
        if(StringUtils.isNotBlank(str)) {
            allResultQueue.add(str);
            return  str;
        } else {
            throw new RuntimeException("失败");
        }
    }

    /**
     * 执行线程任务，并获取返回结果。当异步任务完成或者发生异常时，自动调用回调对象的回调方法。
     * @throws InterruptedException
     */
    @Test
    public void testCompletableFuture() throws InterruptedException {
        // 创建异步执行任务:
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> testSupplyAsync("成功"));
        // 如果执行成功:
        cf.thenAccept((result) -> log.info("测试 --> {}", result) );
        // 如果执行异常:
        cf.exceptionally((e) -> {
            e.printStackTrace();
            return null;
        });

        Thread.sleep(1000);
    }

    /**
     * supplyAsync ：执行线程任务，并获取返回结果。并将传入回调对象传入另一个线程
     * @throws InterruptedException
     */
    @Test
    public void testCompletableFutureSequential() throws InterruptedException {
        // 创建执行任务:
        CompletableFuture<String> c1 = CompletableFuture.supplyAsync(() -> testSupplyAsync("成功"));
        CompletableFuture<String> cf = c1.thenApplyAsync((str) -> testSupplyAsync("执行" + str));
        // 如果执行成功:
        cf.thenAccept((result) -> log.info("测试 --> {}", result) );
        // 如果执行异常:
        cf.exceptionally((e) -> {
            e.printStackTrace();
            return null;
        });

        Thread.sleep(1000);
    }

    /**
     * 多个CompletableFuture可以并行执行
     *      anyOf ：任意一个成功就返回
     *      allOf ：都必须成功才返回
     * @throws InterruptedException
     */
    @Test
    public void testCompletableFutureParallel() throws InterruptedException, TimeoutException, ExecutionException {
        // 创建并发任务:
        CompletableFuture<String> c1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return testSupplyAsync("任务一");});
        CompletableFuture<String> c2 = CompletableFuture.supplyAsync(() -> testSupplyAsync("任务二"));
        // 用anyOf合并为一个新的CompletableFuture:
        CompletableFuture<Object> anyOf = CompletableFuture.anyOf(c1, c2);

        // 如果执行成功。 只要任意一个返回结果就结束
        anyOf.thenAccept((result) -> log.info("anyOf 测试 --> {}", result) );
        // 如果执行异常:
        anyOf.exceptionally((e) -> {
            e.printStackTrace();
            return null;
        });

        CompletableFuture<String> c3 = CompletableFuture.supplyAsync(() -> testSupplyAsync("任务三"));
        CompletableFuture.allOf(c1, c2, c3).get(200, TimeUnit.MILLISECONDS);
        List<String> allResult = new ArrayList<>(allResultQueue);
        log.info("allOf 测试 --> {}", allResult);

//        CompletableFuture<String> c3 = CompletableFuture.supplyAsync(() -> testSupplyAsync("任务三"));
//        CompletableFuture<Void> allOf = CompletableFuture.allOf(c1, c2, c3);
//        // 如果执行成功。 只要任意一个返回结果就结束
//        allOf.thenAccept((result) -> {
//            List<String> allResult = new ArrayList<>(allResultQueue);
//            log.info("allOf 测试 --> {}", allResult);
//        } );
//        // 如果执行异常:
//        allOf.exceptionally((e) -> {
//            e.printStackTrace();
//            return null;
//        });

        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(1000);
    }


}
