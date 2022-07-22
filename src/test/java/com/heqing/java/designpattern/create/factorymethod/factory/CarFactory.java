package com.heqing.java.designpattern.create.factorymethod.factory;

import com.heqing.java.designpattern.create.factorymethod.model.Car;

/**
 * @author heqing
 * @date 2021/12/22 10:42
 */
public class CarFactory {

    public static  <T extends Car> T createCar(Class<T> c){
        Car car = null;
        try{
            car = (T)Class.forName(c.getName()).newInstance();
        }catch(Exception e){
            System.out.println("生产汽车失败！");
        }
        return (T)car;
    }

}
