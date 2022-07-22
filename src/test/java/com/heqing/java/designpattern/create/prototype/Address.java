package com.heqing.java.designpattern.create.prototype;

/**
 * @author heqing
 * @date 2021/12/21 10:42
 */
public class Address implements Cloneable {

    private String province;

    private String city;

    public Address(String province, String city) {
        this.province = province;
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public Object clone() {
        Address clone=null;
        try {
            clone=(Address) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
