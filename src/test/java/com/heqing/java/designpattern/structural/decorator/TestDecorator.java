package com.heqing.java.designpattern.structural.decorator;

import org.junit.jupiter.api.Test;

/**
 * 装饰模式是一种结构型设计模式。
 * 动态地给一个对象添加一些额外的职责，就增加功能来说，装饰模式比生成子类更灵活
 *
 * @author heqing
 * @date 2021/12/23 15:16
 */
public class TestDecorator {

    @Test
    public void testDecorator() {
        // 制作一杯奶茶
        MilkTea milkTea = new MilkTea();
        // 奶茶中加一点珍珠
        ActivePearl pearlTea = new ActivePearl(milkTea);
        // 珍珠奶茶中再放点红豆
        ActiveRedBean redBean = new ActiveRedBean(pearlTea);
        // 这是一杯什么奶茶
        redBean.show();
    }
}
