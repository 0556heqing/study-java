package com.heqing.java.designpattern.structural.facade;

import org.junit.jupiter.api.Test;

/**
 * 外观模式是一种结构型设计模式。
 * 提供了一个统一的接口，用来访问子系统中的一群接口。外观模式定义了一个高层接口，让子系统更容易使用。
 *
 * 目的（本质就是，封装交互、简化调用）：
 * 为了让外部减少与子系统内部多个模块的交互，松散耦合，包装内部已有的接口，从而让外部系统简单使用子系统。
 *
 * 外观模式结构和说明
 * Facade：定义子系统的多个模块的高层接口，通常需要调用内部多个模块，从而把客户的请求代理给适当的子系统对象
 * Model：接受Facade的调用，真正实现功能，各模块间可能有交叉
 * 注意：Facade知道各模块，但各个模块不知道Facade对象
 *
 * 优点：松散耦合、简单易用、更好的划分访问层次。
 * 缺点：过多的Facade令人迷惑，到底调用Facade好还是Model好？
 *
 * @author heqing
 * @date 2021/12/23 16:41
 */
public class TestFacade {

    @Test
    public void testFacade() {
        // 以前，患者问诊，可能要先去窗口挂号，再去科室问诊，最后在窗口付费
        // 现在，通过互联网医院，只要在一个平台下操作所有流程

        // Facade就是这个平台，通过它可以简化调用
        Facade facade = new Facade();
        facade.active();
    }
}
