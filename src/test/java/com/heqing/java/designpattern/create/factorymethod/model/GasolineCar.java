package com.heqing.java.designpattern.create.factorymethod.model;

/**
 * Car 具体实现类 B
 * @author heqing
 * @date 2021/12/22 10:41
 */
public class GasolineCar implements Car {

    @Override
    public void name() {
        System.out.println("汽油车");
    }
}
