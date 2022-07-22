package com.heqing.java.designpattern.create.builder;

/**
 * 主要定义创建步骤的执行顺序，而具体的步骤则由生成器中的具体类实现
 *
 * @author heqing
 * @date 2021/12/21 18:29
 */
public class Director {

    public static void builder(MakeFood make) {
        make.prepareFood();
        make.fryFood();
        make.eatFood();
    }
}
