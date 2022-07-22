package com.heqing.java.designpattern.behavioral.mediator;

import org.junit.jupiter.api.Test;

/**
 * 中介者模式是一种行为型模式。
 * 定义了一个中介对象来封装一系列对象之间的交互关系。中介者使各个对象之间不需要显式地相互引用，
 * 从而使耦合性降低，而且可以独立地改变它们之间的交互行为。
 *
 * 本质：封装交互
 * 目的：实现封装对象之间的交互功能。
 *
 * 结构：
 *  Mediator : 中介者接口，定义各个同事之间交互需要的方法
 *  ConcreteMediator : 具体中介者的实现对象。需要了解并维护各个同时对象，并负责具体的协调各同事对象的交互关系
 *  Colleague : 同事类的定义，通常实现成为抽象类，主要负责约束同事对象的类型，并实现一些具体同事类之间的公共方法
 *  ConcreteColleague : 具体同事类，实现自己的业务，在需要与其他同事类交互时，就与中介者通信，由中介者访问其他同事类
 *
 * 适用场景：
 *  1.一组对象之间的调用方式复杂，导致相互依赖、结构混乱。采用中介者模式，各对象只需与中介者交互，从而使各对象松散耦合
 *  2.一个对象需要引用很多对象，并直接跟这些对象交互，导致难以复用该对象。
 *
 * @author heqing
 * @date 2021/12/24 10:16
 */
public class TestMediator {

    @Test
    public void testMediator() {
        // 房产中介来了
        HouseMediator mediator = new HouseMediator();

        // 有两个人买房子
        Seller seller1 = new Seller(mediator,"卖方A");
        Seller seller2 = new Seller(mediator, "卖方B");
        // 有一个人买房子
        Buyer buyer1 = new Buyer(mediator, "买方A");

        // 房产中介收集买卖双方信息
        mediator.addSeller(seller1);
        mediator.addSeller(seller2);
        mediator.addBuyer(buyer1);

        // 卖方发布消息
        seller1.send("想卖别墅");
        seller2.send("想卖大平层");

        // 买方发布消息
        buyer1.send("想买300万左右的房子");

        // 中介发布消息
        mediator.sendMsg(buyer1, "又不想买了");
    }
}
