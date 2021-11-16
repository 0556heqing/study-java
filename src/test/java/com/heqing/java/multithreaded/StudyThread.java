package com.heqing.java.multithreaded;

import com.alibaba.fastjson.JSONObject;
import com.github.houbb.junitperf.core.annotation.JunitPerfConfig;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.*;

public class StudyThread {

    private static Logger log = LoggerFactory.getLogger(StudyThread.class);

    class MyRunnable implements Runnable {
        @Override
        public void run() {
            log.info("实现接口方式， 启动了一个新线程！");
        }
    }

    @Test
    public void testCreateThread() {
        log.info("主线程 - 开始！");
        // 从Thread派生一个自定义类，然后覆写run()方法
        Thread t = new Thread(() -> {
            log.info("继承方式， 启动了一个新线程！");
        });
        t.start();

        // 实现 Runnable 接口，然后覆写run()方法
        t = new Thread(new MyRunnable());
        t.start(); // 启动新线程
        log.info("主线程 - 结束！");
    }

    @Test
    public void testThreadStatus() throws InterruptedException {
        log.info("主线程 - 开始！");
        Thread t = new Thread(new MyRunnable());
//        t.setName("守护线程");
        // 设置为守护线程。守护线程不能持有需要关闭的资源（如打开文件等）
        // thread.setDaemon(true)必须在thread.start()之前设置，否则会跑出一个IllegalThreadStateException异常。你不能把正在运行的常规线程设置为守护线程。
//        t.setDaemon(true);
        // 启动线程
        t.start();
        // 等待该线程结束，然后才继续往下执行主线程
//        t.join();
        // 中断线程
//        t.interrupt();
        log.info("主线程 - 结束！");
    }

    private static Integer num = 0;

    @Test
    public void testSynchronized() throws InterruptedException {
        Object lock = new Object();

        Thread t1 = new Thread(() -> {
            for(int i=0; i<100000; i++) {
                // 保证了代码块在任意时刻最多只有一个线程能执行。。因为synchronized代码块无法并发执行。此外，加锁和解锁需要消耗一定的时间，所以，synchronized会降低程序的执行效率。
                synchronized(lock) {
                    num += 1;
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            for(int i=0; i<100000; i++) {
                synchronized(lock) {
                    num -= 1;
                }
            }
        });
        t2.start();

        t1.join();
        t2.join();
        System.out.println("主线程 --> 结束！ num = " + num);
    }

    // 锁
    private final ReentrantLock lock = new ReentrantLock();

    @JunitPerfConfig(threads = 5, warmUp = 5, duration = 10)
    public void testReentrantLock() throws InterruptedException {
        if (lock.tryLock()) {
            log.info("--> 成功获取锁！");
            try {
                num += 1;
            } finally {
                Thread.sleep(5000);
                lock.unlock();
            }
        } else {
            log.info("--> 获取锁失败！ 当前值：{}" , num);
        }
    }

    // 读写锁(悲观锁)
    private final ReadWriteLock rwlock = new ReentrantReadWriteLock();
    private final Lock rlock = rwlock.readLock();
    private final Lock wlock = rwlock.writeLock();

    @JunitPerfConfig(threads = 5, warmUp = 5, duration = 10)
    public void testReadWriteLock() throws InterruptedException {
        // 把读写操作分别用读锁和写锁来加锁，在读取时，多个线程可以同时获得读锁，这样就大大提高了并发读的执行效率。

        // 只允许一个线程写入（其他线程既不能写入也不能读取）；
        if (wlock.tryLock()) {
            log.info("--> 成功获取写锁！当前值：{}", num);
            try {
                num += 1;
            } finally {
                wlock.unlock();
            }
        } else {
            // 没有写入时，多个线程允许同时读（提高性能）。
            rlock.lock();
            try {
                log.info("--> 成功获取读锁！当前值：{}", num);
            } finally {
                Thread.sleep(5000);
                rlock.unlock();
            }
        }
    }

    // 读写锁（java8引入，乐观锁）
    private final StampedLock rwNewlock = new StampedLock();

    @JunitPerfConfig(threads = 5, warmUp = 5, duration = 10)
    public void testStampedLock() throws InterruptedException {
        long stamp = rwNewlock.writeLock(); // 获取写锁
        log.info("--> 成功获取写锁！当前值：{}", stamp);
        try {
            num += 1;
        } finally {
            Thread.sleep(5000);
            rwNewlock.unlockWrite(stamp); // 释放写锁
        }
    }


    Map<String, String> cMap = new ConcurrentHashMap<>();
    Map<String, String> hMap = new HashMap<>();

    @JunitPerfConfig(threads = 5, warmUp = 5, duration = 10)
    public void testConcurrent() {
        hMap.put(Thread.currentThread().getName(), "线程集合");
        cMap.put(Thread.currentThread().getName(), "线程集合");
        log.info("cMap --> {}", JSONObject.toJSONString(cMap));
        log.info("hMap --> {}", JSONObject.toJSONString(hMap));
    }

    AtomicInteger ai = new AtomicInteger(0);

    @JunitPerfConfig(threads = 5, warmUp = 5, duration = 10)
    public void testAtomicInteger() {
        for(int i=0; i<1000000; i++){
            ai.incrementAndGet();
            num = i+1;
        }
        log.info("--> num={}, ai={}", num, ai.get());
    }

    private static final ThreadLocal<String> TTL = ThreadLocal.withInitial(() -> null);

    @JunitPerfConfig(threads = 5, warmUp = 5, duration = 10)
    public void testThreadLocal() {
        setValue();
        getValue();
    }

    void setValue() {
        TTL.set(Thread.currentThread().getName());
    }

    void getValue() {
        log.info("--> 当前线程中的值为：{}", TTL.get());
    }
}
