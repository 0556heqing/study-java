package com.heqing.java.designpattern.create.factorymethod.manyfactory;

import com.heqing.java.designpattern.create.factorymethod.model.GasolineCar;

/**
 * @author heqing
 * @date 2021/12/22 11:01
 */
public class GasolineCarFactory implements CarFactory {

    public GasolineCar createCar() {
        return new GasolineCar();
    }
}
