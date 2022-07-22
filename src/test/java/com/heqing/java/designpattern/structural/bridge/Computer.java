package com.heqing.java.designpattern.structural.bridge;

import com.heqing.java.designpattern.structural.bridge.brand.Brand;

/**
 * @author heqing
 * @date 2021/12/22 21:15
 */
public abstract class Computer {

    protected Brand brand;

    public Computer(Brand brand) {
        this.brand = brand;
    }

    public abstract void model();
}
