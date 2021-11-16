package com.heqing.java.multithreaded;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.LongStream;

public class StudyForkJoin {

    @Test
    public void testForkJoin() throws Exception{
        long start = 0L;
        long end = 100000000L;

        for(int i=0;i<5;i++) {
            testSum(start,end);
            testForkJoin(start,end);
            testParallelStream(start,end);
            testSequentialStream(start,end);
            System.out.println("-----------------------------");
        }
    }

    /**
     * 普通for循环
     * @param start
     * @param end
     */
    public static void testSum(Long start,Long end){
        long l = System.currentTimeMillis();
        long sum = 0L;
        for (long i = start; i <= end ; i++ ) {
            sum += i;
        }
        long l1 = System.currentTimeMillis();
        System.out.println("普通for循环结果:" +sum+",耗时:"+(l1-l));
    }

    /**
     * forkjoin方式
     * @param start
     * @param end
     * @throws Exception
     */
    public static void testForkJoin(long start,long end) throws Exception{
        long l = System.currentTimeMillis();

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinWork task = new ForkJoinWork(start,end);
        long invoke = forkJoinPool.invoke(task);

        long l1 = System.currentTimeMillis();
        System.out.println("forkjoin结果:"+invoke+",耗时:"+(l1-l));
    }

    /**
     * stream并行流
     * @param start
     * @param end
     */
    public static void testParallelStream(Long start,Long end){
        long l = System.currentTimeMillis();
        long reduce = LongStream.rangeClosed(start, end).parallel().reduce(0, (x, y) -> x+y);
        long l1 = System.currentTimeMillis();
        System.out.println("parallel_stream流结果:"+reduce+",耗时:"+(l1-l));
    }

    /**
     * stream串行流
     * @param start
     * @param end
     */
    public static void testSequentialStream(Long start,Long end){
        long l = System.currentTimeMillis();
        long reduce = LongStream.rangeClosed(start, end).sequential().reduce(0, (x, y) -> x+y);
        long l1 = System.currentTimeMillis();
        System.out.println("sequential_Stream流结果:"+reduce+",耗时:"+(l1-l));
    }
}
