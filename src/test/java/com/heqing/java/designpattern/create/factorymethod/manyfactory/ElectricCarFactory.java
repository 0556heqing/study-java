package com.heqing.java.designpattern.create.factorymethod.manyfactory;

import com.heqing.java.designpattern.create.factorymethod.model.ElectricCar;

/**
 * @author heqing
 * @date 2021/12/22 10:58
 */
public class ElectricCarFactory implements CarFactory {

    public ElectricCar createCar() {
        return new ElectricCar();
    }
}
