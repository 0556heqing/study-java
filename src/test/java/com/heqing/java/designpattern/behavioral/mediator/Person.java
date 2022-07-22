package com.heqing.java.designpattern.behavioral.mediator;

/**
 * @author heqing
 * @date 2021/12/24 14:35
 */
public abstract class Person {

    private Mediator mediator;
    private String name;

    public Person(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
        System.out.println("我是：" + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    abstract void send(String msg);

    abstract void receive(String msg);
}
