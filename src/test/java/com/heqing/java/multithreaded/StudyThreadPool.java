package com.heqing.java.multithreaded;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * @author heqing
 * @date 2021/7/8 17:34
 */
public class StudyThreadPool {

    private static Logger log = LoggerFactory.getLogger(StudyThreadPool.class);

    @Test
    public void testExecutorService() throws InterruptedException {
        /**
         * corePoolSize	int	核心线程池大小。。，最多执行数量。等到有线程空闲后，再执行后面的线程
         * maximumPoolSize	int	最大线程池大小
         * keepAliveTime	long	线程最大空闲时间
         * unit	TimeUnit	时间单位
         * workQueue	BlockingQueue<Runnable>	线程等待队列
         * handler	RejectedExecutionHandler	拒绝策略
         */
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,
                100,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100),
                new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 10; i++) {
            executor.submit(new Thread(() -> {
                log.info("线程池 --> 启动了一个新线程！");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }));
        }
        // 关闭线程池:
        executor.shutdown();
        Thread.sleep(10000);
    }

    @Test
    public void testScheduledThreadPool() throws InterruptedException {
        // 放入ScheduledThreadPool的任务可以定期反复执行
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(5);

        log.info("---> 准备执行反复任务了");

        // 1秒后执行一次性任务:
        ses.schedule(new Thread(() -> {
            log.info("1 --> 当前线程 1秒后执行");
        }), 1, TimeUnit.SECONDS);

        // 2秒后开始执行定时任务，每3秒执行
        ses.scheduleAtFixedRate(new Thread(() -> {
            log.info("2 --> 当前线程 2秒后执行，每3秒一次");
        }), 2, 3, TimeUnit.SECONDS);

        // 2秒后开始执行定时任务，以3秒为间隔执行
        ses.scheduleWithFixedDelay(new Thread(() -> {
            log.info("3 --> 当前线程 2秒后执行，3秒间隔一次");
        }), 2, 3, TimeUnit.SECONDS);

        Thread.sleep(10000);

        ses.shutdown();
        log.info("---> 反复任务已终止");

        Thread.sleep(5000);
    }
}
