package com.heqing.java.designpattern.create.singleton;

import org.junit.jupiter.api.Test;

/**
 * 单例模式是一种创建型设计模式。可以保证一个类只有一个实例，并提供一个访问该实例的全局节点
 *
 * 本质：控制实例数目
 *
 * 实现方式：
 *  1.在类中添加私有静态变量用于保存单例实例
 *  2.声明一个公有静态方法用于获取单例实例
 *  3.在静态方法中实现“延迟初始化”。会在首次调用时创建实例，并存储在静态变量中。此后方法调用时都返回该实例
 *  4.将类的构造方法设为私有。只有静态方法能调用构造方法，其他对象都不能调用
 *  5.在使用该类的对象时，使用静态构造方法调用
 *
 * @author heqing
 * @date 2021/12/20 19:08
 */
public class TestSingleton {

    @Test
    public void testLaiHan() {
        LaiHan instance1 = LaiHan.getInstance();
        System.out.println("-->" + instance1);

        LaiHan instance2 = LaiHan.getInstance();
        System.out.println("-->" + instance2);

        System.out.println("-->" + (instance1 == instance2));
    }

    @Test
    public void testEHan() {
        EHan instance1 = EHan.getInstance();
        System.out.println("-->" + instance1);

        EHan instance2 = EHan.getInstance();
        System.out.println("-->" + instance2);

        System.out.println("-->" + (instance1 == instance2));
    }

    @Test
    public void testInteriorClass() {
        Thread thread3 = new Thread(new Thread3());
        Thread thread4 = new Thread(new Thread4());
        thread3.start();
        thread4.start();
    }


    @Test
    public void testDoubleCheck() {
        // 多运行几次会发现：lanHan实例可能不相同，而DoubleCheck实例都是相同的
        Thread thread1 = new Thread(new Thread1());
        Thread thread2 = new Thread(new Thread2());
        thread1.start();
        thread2.start();
    }

    static class Thread1 implements Runnable {
        @Override
        public void run() {
            LaiHan lanHan = LaiHan.getInstance();
            System.out.println("lanHan -->" + lanHan);

            DoubleCheck doubleCheck = DoubleCheck.getInstance();
            System.out.println("doubleCheck -->" + doubleCheck);
        }
    }

    static class Thread2 implements Runnable {
        @Override
        public void run() {
            LaiHan lanHan = LaiHan.getInstance();
            System.out.println("lanHan -->" + lanHan);

            DoubleCheck doubleCheck = DoubleCheck.getInstance();
            System.out.println("doubleCheck -->" + doubleCheck);
        }
    }

    static class Thread3 implements Runnable {
        @Override
        public void run() {
            LaiHan lanHan = LaiHan.getInstance();
            System.out.println("lanHan -->" + lanHan);

            InteriorClass instance = InteriorClass.getInstance();
            System.out.println("内部类1 -->" + instance);
        }
    }

    static class Thread4 implements Runnable {
        @Override
        public void run() {
            LaiHan lanHan = LaiHan.getInstance();
            System.out.println("lanHan -->" + lanHan);

            InteriorClass instance = InteriorClass.getInstance();
            System.out.println("内部类2 -->" + instance);
        }
    }
}
