package com.heqing.java.designpattern.structural.composite;

/**
 * @author heqing
 * @date 2021/12/23 14:42
 */
public abstract class Organization {

    String name;

    public Organization(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void display();

}
