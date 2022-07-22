package com.heqing.java.designpattern.behavioral.strategy;

/**
 * @author heqing
 * @date 2021/12/24 17:46
 */
public class Person {

    private Transport transport;

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public void method(){
        transport.travel();
    }

}
