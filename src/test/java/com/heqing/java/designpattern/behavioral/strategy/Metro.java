package com.heqing.java.designpattern.behavioral.strategy;

/**
 * @author heqing
 * @date 2021/12/24 17:45
 */
public class Metro implements Transport {

    @Override
    public void travel() {
        System.out.println("地铁出行");
    }
}
