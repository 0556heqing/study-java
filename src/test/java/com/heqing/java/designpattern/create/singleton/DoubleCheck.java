package com.heqing.java.designpattern.create.singleton;

/**
 * 双重校验锁：综合了懒汉式和饿汉式两者的优缺点整合而成。双重校验锁保证了线程安全性，懒汉式是线程不安全的
 * @author heqing
 * @date 2021/12/20 19:28
 */
public class DoubleCheck {

    private volatile static DoubleCheck instance;

    private DoubleCheck() {}

    public static DoubleCheck getInstance() {
        // 保证了线程安全，又比直接上锁提高了执行效率，还节省了内存空间
        if(instance == null) {
            synchronized (DoubleCheck.class) {
                if (instance == null) {
                    instance = new DoubleCheck();
                }
            }
        }
        return instance;
    }

}
