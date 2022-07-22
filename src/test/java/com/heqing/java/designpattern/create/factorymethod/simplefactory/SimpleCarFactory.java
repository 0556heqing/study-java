package com.heqing.java.designpattern.create.factorymethod.simplefactory;

import com.heqing.java.designpattern.create.factorymethod.model.Car;
import com.heqing.java.designpattern.create.factorymethod.model.ElectricCar;
import com.heqing.java.designpattern.create.factorymethod.model.GasolineCar;

/**
 * 工厂类，用来创造Api对象
 * @author heqing
 * @date 2021/12/22 11:18
 */
public class SimpleCarFactory {

    private SimpleCarFactory() {
    }

    /**
     * 使用简单工厂通常没有创建实例的必要，使用静态方法就可以了。也就是说简单工厂方法通常是静态的，也称静态工厂。
     * 为防止客户端无谓创建还可以把构造方法私有化
     * @param carType
     * @return
     */
    public static Car createCar(CarEnum carType) {
        // 应该根据某些条件去选择究竟创建哪一个具体的实现对象，
        // 这些条件可以从外部传入，也可以从其它途径获取。
        // 如果只有一个实现，可以省略条件，因为没有选择的必要。
        Car car = null;
        switch (carType) {
            case ELECTRIC_CAR:
                car = new ElectricCar();
                break;
            case GASOLINE_CAR:
                car = new GasolineCar();
                break;
        }
        return car;
    }
}
