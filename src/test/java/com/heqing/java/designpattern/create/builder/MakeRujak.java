package com.heqing.java.designpattern.create.builder;

/**
 * @author heqing
 * @date 2021/12/21 18:25
 */
public class MakeRujak implements MakeFood {

    @Override
    public void prepareFood() {
        System.out.println("网上购买水果，配送到家");
    }

    @Override
    public void fryFood() {

    }

    @Override
    public void eatFood() {
        System.out.println("一起来吃水果沙拉");
    }
}
