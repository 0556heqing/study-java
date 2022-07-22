package com.heqing.java.designpattern.create.builder;

import com.alibaba.fastjson.JSONObject;

/**
 * @author heqing
 * @date 2021/12/21 15:23
 */
public class Computer {

    private final String brand;
    private final String cpu;

    private Computer(Builder builder){
        this.cpu=builder.cpu;
        this.brand=builder.brand;
    }

    public String getCpu() {
        return cpu;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public static class Builder {

        private String cpu;
        private String brand;

        public Builder(String brand){
            this.brand = brand;
        }

        public Builder setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Computer build(){
            return new Computer(this);
        }
    }

}
