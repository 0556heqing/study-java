package com.heqing.java.designpattern.create.singleton;

/**
 * 懒汉式：用的时候才去检查有没有实例，如果有则返回，没有则新建
 * @author heqing
 * @date 2021/12/20 19:19
 */
public class LaiHan {

    private static LaiHan instance;

    private LaiHan() {}

    public static LaiHan getInstance() {
        // 用到的时候再判断是否实例化
        if(instance == null) {
            instance = new LaiHan();
        }
        return instance;
    }
}
