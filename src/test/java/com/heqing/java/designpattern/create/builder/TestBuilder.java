package com.heqing.java.designpattern.create.builder;

import org.junit.jupiter.api.Test;

/**
 * 建造者模式是一种对象创建型模式。该模式可以使用相同的创建代码生成不同类型和形式的对象
 * 它是将一个复杂对象的构建过程隐藏起来，让使用者只关心自己要生成什么样的对象。即创建和表示分离。
 *
 * 主要功能：
 *  构建复杂的产品，而且是细化的、分步骤的构建产品，也就是生成器模式重在一步步解决构造复杂对象的问题
 *
 * 构成：
 *  1.Builder接口，这里定义了如何构建各个部分，也就是知道每个部件功能如何实现，一级如何装配这个不见到产品中去
 *  2.Directir，这里知道如何组合来构建产品，也就是它负责整体的构建算法，而且通常是分步骤地执行
 *
 * @author heqing
 * @date 2021/12/21 14:42
 */
public class TestBuilder {

    @Test
    public void testDirector() {
        /**
         * 客户端创造Director，在Director中封装整体的构建算法。
         * 然后让Director去调用Builder，让Builder来封装具体部件的构建功能
         */
        // 经典的Builder模式
        Director.builder(new MakeFish());
        System.out.println("-----------------");
        Director.builder(new MakeRujak());
    }

    @Test
    public void testBuilder() {
        /**
         * 构建复杂对象的实现方式：
         *  1.类的属性都设为final不可变的（没有set方法）
         *  2.构造方法设为private，不允许自定义生成
         *  3.设置静态内部类Builder，拷贝属性信息
         *  4.设置Builder构造方法，set方法，及build方法
         */
        // 省略掉了Director。假如实体类很多的情况
        Computer macBook = new Computer.Builder("苹果").build();
        Computer huaweiBook = new Computer.Builder("华为").setCpu("酷睿I7").build();

        System.out.println("macBook --> " + macBook);
        System.out.println("huaweiBook --> " + huaweiBook);
    }

}
