package com.heqing.java.designpattern.create.singleton;

/**
 * 类级内部类实现单例，该方法也是线程安全的
 * getInstance第一次被调用时，第一次读取SingletonHolder.interiorClass，导致SingletonHolder类初始化；
 * 而这个类初始化时，会初始化他的静态域，从而创建InteriorClass实例，由于是静态的域，因此只有在虚拟机装载类的时候初始化一次，并由虚拟机来保证他的线程安全性
 *
 * @author heqing
 * @date 2022/1/6 20:22
 */
public class InteriorClass {

    private InteriorClass() {}

    public static InteriorClass getInstance() {
        return SingletonHolder.interiorClass;
    }

    /**
     * 类的内部类，也就是静态的成员内部类，该内部类的实例与外部类的实例没有绑定关系，而且只有被调用到时才会装载，从而实现了延迟加载
     */
    private static class SingletonHolder {
        /**
         * 静态初始化器，由JVM来保证线程安全
         */
        private static InteriorClass interiorClass = new InteriorClass();
    }
}
