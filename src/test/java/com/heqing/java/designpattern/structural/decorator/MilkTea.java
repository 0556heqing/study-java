package com.heqing.java.designpattern.structural.decorator;

/**
 * @author heqing
 * @date 2021/12/23 15:36
 */
public class MilkTea implements Tea {

    @Override
    public void show() {
        System.out.println("奶茶");
    }
}
