package com.heqing.java.designpattern.structural.facade;

/**
 * @author heqing
 * @date 2021/12/23 16:59
 */
public class Window {

    public void register() {
        System.out.println("正在窗口 挂号");
    }

    public void pay() {
        System.out.println("正在窗口 付诊费");
    }

}
