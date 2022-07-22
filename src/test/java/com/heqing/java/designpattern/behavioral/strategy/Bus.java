package com.heqing.java.designpattern.behavioral.strategy;

/**
 * @author heqing
 * @date 2021/12/24 17:44
 */
public class Bus implements Transport {

    @Override
    public void travel() {
        System.out.println("公共汽车出行");
    }
}
