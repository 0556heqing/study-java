package com.heqing.java.multithreaded;

import java.util.concurrent.RecursiveTask;

/**
 * @author heqing
 * Fork/Join线程池
 * 它可以把一个大任务拆成多个小任务并行执行
 * 这就是Fork/Join任务的原理：判断一个任务是否足够小，如果是，直接计算，否则，就分拆成几个小任务分别计算。这个过程可以反复“裂变”成一系列小任务
 * Java标准库提供的java.util.Arrays.parallelSort(array)可以进行并行排序，它的原理就是内部通过Fork/Join对大数组分拆进行并行排序，在多核CPU上就可以大大提高排序的速度。
 */
public class ForkJoinWork extends RecursiveTask<Long> {

    private long start;
    private long end;

    /**
     * 临界点
     */
    private static final long THRESHOLD = 10000L;

    public ForkJoinWork(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end - start < THRESHOLD) {
            // 如果任务足够小,直接计算
            long sum = 0L;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            // 任务太大,一分为二:
            long middle = (end + start) / 2;
            ForkJoinWork subtask1 = new ForkJoinWork(start, middle);
            ForkJoinWork subtask2 = new ForkJoinWork(middle + 1, end);
            invokeAll(subtask1, subtask2);
            return subtask1.join() + subtask2.join();
        }
    }
}