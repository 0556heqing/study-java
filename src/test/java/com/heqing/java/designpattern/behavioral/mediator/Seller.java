package com.heqing.java.designpattern.behavioral.mediator;

/**
 * @author heqing
 * @date 2021/12/24 14:44
 */
public class Seller extends Person {

    public Seller(Mediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    void send(String msg) {
        this.getMediator().sendMsg(this, msg);
    }

    @Override
    void receive(String msg) {
        System.out.println(getName() + "，收到了消息：" + msg);
    }
}
