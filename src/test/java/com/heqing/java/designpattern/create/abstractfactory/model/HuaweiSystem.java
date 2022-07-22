package com.heqing.java.designpattern.create.abstractfactory.model;

/**
 * @author heqing
 * @date 2021/12/22 14:36
 */
public class HuaweiSystem implements OperatingSystem {

    @Override
    public void name() {
        System.out.println("  鸿蒙 操作系统");
    }
}
