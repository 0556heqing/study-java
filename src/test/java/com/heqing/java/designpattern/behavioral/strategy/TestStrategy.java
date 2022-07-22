package com.heqing.java.designpattern.behavioral.strategy;

import org.junit.jupiter.api.Test;

/**
 * 策略模式是一种行为型模式。
 * 定义了一系列的算法，并将每一个算法封装起来，而且使它们还可以相互替换。策略模式让算法独立于使用它的客户而独立变化。
 *
 * @author heqing
 * @date 2021/12/24 10:18
 */
public class TestStrategy {

    @Test
    public void testStrategy() {
        // 一个人
        Person person = new Person();
        // 两种出行方式
        Transport bus = new Bus();
        Transport metro = new Metro();

        // 选择做公交车
        person.setTransport(bus);
        person.method();

        // 选择做地铁
        person.setTransport(metro);
        person.method();
    }
}
