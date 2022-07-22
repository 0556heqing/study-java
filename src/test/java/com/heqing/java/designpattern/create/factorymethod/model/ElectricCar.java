package com.heqing.java.designpattern.create.factorymethod.model;

/**
 * Car 具体实现类 A
 * @author heqing
 * @date 2021/12/22 10:39
 */
public class ElectricCar implements Car {

    @Override
    public void name() {
        System.out.println("电动车");
    }
}
