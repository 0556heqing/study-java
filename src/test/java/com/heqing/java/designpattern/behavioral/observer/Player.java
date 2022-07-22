package com.heqing.java.designpattern.behavioral.observer;

/**
 * @author heqing
 * @date 2021/12/24 16:52
 */
public class Player implements Observer {

    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + "-" + message);
    }
}
