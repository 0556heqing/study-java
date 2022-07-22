package com.heqing.java.designpattern.structural.composite;


/**
 * @author heqing
 * @date 2021/12/23 14:45
 */
public class Staff extends Organization {

    public Staff(String name) {
        super(name);
    }

    public void display() {
        System.out.println("员工：" + super.getName());
    }
}
