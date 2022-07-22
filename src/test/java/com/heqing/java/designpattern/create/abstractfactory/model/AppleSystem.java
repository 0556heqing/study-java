package com.heqing.java.designpattern.create.abstractfactory.model;

/**
 * @author heqing
 * @date 2021/12/22 14:39
 */
public class AppleSystem implements OperatingSystem {

    @Override
    public void name() {
        System.out.println("  ios 操作系统");
    }
}
