package com.heqing.java.designpattern.create.prototype;

/**
 * @author heqing
 * @date 2021/12/21 10:27
 */
public class Person implements Cloneable {

    protected String name;

    protected Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
