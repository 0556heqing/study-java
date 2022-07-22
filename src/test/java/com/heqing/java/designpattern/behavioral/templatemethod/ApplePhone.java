package com.heqing.java.designpattern.behavioral.templatemethod;

/**
 * @author heqing
 * @date 2021/12/27 10:05
 */
public class ApplePhone extends MobilePhone {
    @Override
    public void system() {
        System.out.println("组装IOS操作系统");
    }

    @Override
    public void chip() {
        System.out.println("组装A系列芯片");
    }
}
