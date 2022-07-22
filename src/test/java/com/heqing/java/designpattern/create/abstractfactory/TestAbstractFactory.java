package com.heqing.java.designpattern.create.abstractfactory;

import org.junit.jupiter.api.Test;

/**
 * 抽象工厂模式是一种创建型模式。能创建一系列相关的对象，而无需指定具体类
 * 抽象工厂的功能是为一系列相关对象货相互依赖的对象创建一个接口。AbstractFactory 通常实现为接口，而不是抽象类
 *
 * @author heqing
 * @date 2021/12/22 14:10
 */
public class TestAbstractFactory {

    @Test
    public void testAbstractFactory() {
        HuaweiFactory huaweiFactory = new HuaweiFactory();
        huaweiFactory.make();

        AppleFactory appleFactory = new AppleFactory();
        appleFactory.make();
    }
}
