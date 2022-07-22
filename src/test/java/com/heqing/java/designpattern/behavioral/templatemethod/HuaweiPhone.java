package com.heqing.java.designpattern.behavioral.templatemethod;

/**
 * @author heqing
 * @date 2021/12/27 10:04
 */
public class HuaweiPhone extends MobilePhone {

    @Override
    public void system() {
        System.out.println("组装鸿蒙操作系统");
    }

    @Override
    public void chip() {
        System.out.println("组装麒麟芯片");
    }
}
