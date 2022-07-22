package com.heqing.java.designpattern.create.factorymethod;

import com.heqing.java.designpattern.create.factorymethod.model.Car;
import com.heqing.java.designpattern.create.factorymethod.model.ElectricCar;
import com.heqing.java.designpattern.create.factorymethod.model.GasolineCar;
import com.heqing.java.designpattern.create.factorymethod.manyfactory.ElectricCarFactory;
import com.heqing.java.designpattern.create.factorymethod.manyfactory.GasolineCarFactory;
import com.heqing.java.designpattern.create.factorymethod.factory.CarFactory;
import com.heqing.java.designpattern.create.factorymethod.simplefactory.CarEnum;
import com.heqing.java.designpattern.create.factorymethod.simplefactory.SimpleCarFactory;
import org.junit.jupiter.api.Test;

/**
 * 工厂方法模式是一种对象创建型模式。定义一个用于创建对象的接口，让子类决定实例化哪一个类
 *
 * 为什么要使用简单工厂模式(静态工厂)？
 * 在Java应用开发中，要“面向接口编程”。而接口的思想是“封装隔离”。也就是说，客户端不应该知道具体的实现类，而应该只知道接口名。
 * 例如常规定义：Api api = new Impl(); 客户端不但知道了接口，同时还知道了具体的实现就是Impl。
 * 简单工厂能帮助我们真正开始面向接口编程，像以前的做法，其实只是用到了接口的多态那部分的功能，最重要的“封装隔离性”并没有体现出来。
 *
 * 简单工厂模式(静态工厂)的定义
 * 提供一个创建对象的功能，而无需关心具体的实现。该对象可以是接口、抽象类、普通类。
 *
 * 简单工厂(静态工厂)结构和说明
 * Api： 定义客户所需要的功能接口（Car）
 * Impl： 具体实现Api的实现类，可能会有多个（ElectricCar、GasolineCar）
 * Factory：工厂，选择合适的实现类来创建Api接口对象（SimpleCarFactory）
 * Client： 客户端，通过Factory去获取Api接口对象，然后面向Api接口编程
 *
 * 简单工厂(静态工厂)
 * 重点在于选择，实现已经做好了。
 * 目的在于为客户端选择相应的实现，从而使客户端和实现类解耦。
 * 难点在于”如何选择“的实现
 *
 * 简单工厂 与 抽象工厂 的差别
 *      简单工厂是用来选择实现的，可能选择任意接口的实现。一个简单工厂有多个选择对象的方法，但这些对象之间是没有关联关系。
 *      抽象工厂是选择产品组的实现，抽象工厂有多个选择和创建对象的方法。这些对象间是有相关关系的，创建的对象通常是产品组的一部分。
 *  两种其实是类似的，如果抽象工厂只有一个实现，部分层次，相当于简单工厂
 *
 * @author heqing
 * @date 2021/12/21 18:44
 */
public class TestFactoryMethod {

    @Test
    public void testSimpleFactoryMethod() {

        // 客户端通过简单工厂创建了一个实现接口的对象，然后面向接口编程。
        // 从客户端来看，它根本就不知道具体的实现是什么，也不知道是如何实现的，它只知道通过工厂获得了一个接口对象，然后就能通过这个接口来获取想要的功能。
        Car electricCar = SimpleCarFactory.createCar(CarEnum.ELECTRIC_CAR);
        electricCar.name();

        Car gasolineCar = SimpleCarFactory.createCar(CarEnum.GASOLINE_CAR);
        gasolineCar.name();
    }


    @Test
    public void testFactoryMethod() {
        /**
         * 简单工厂模式变种，通过代理生成
         * 解决问题：每次新增一个实现类都需要修改工厂类的实现。
         * 思考：但是这个客户端需要知道有哪些实现类，是否破坏了“面向接口“的思想？
         */
        Car electricCar = CarFactory.createCar(ElectricCar.class);
        electricCar.name();

        Car gasolineCar = CarFactory.createCar(GasolineCar.class);
        gasolineCar.name();
    }

    @Test
    public void testManyFactoryMethod() {
        // 多个工厂方法模式
        ElectricCarFactory electricCarFactory = new ElectricCarFactory();
        GasolineCarFactory gasolineCarFactory = new GasolineCarFactory();

        ElectricCar electricCar = electricCarFactory.createCar();
        electricCar.name();

        GasolineCar gasolineCar = gasolineCarFactory.createCar();
        gasolineCar.name();
    }

}
