package com.heqing.java.designpattern.create.singleton;

/**
 * 饿汉式：实例在初始化的时候就已经建好了，不管你有没有用到，都先建好了再说
 * @author heqing
 * @date 2021/12/20 19:21
 */
public class EHan {

    // 声明时直接初始化完成
    private static EHan instance = new EHan();

    private EHan() {}

    public static EHan getInstance() {
        return instance;
    }
}
