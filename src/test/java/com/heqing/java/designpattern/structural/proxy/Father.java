package com.heqing.java.designpattern.structural.proxy;

/**
 * @author heqing
 * @date 2021/12/23 20:05
 */
public class Father implements Person {

    private Son son = null;

    public Father(Son son) {
        this.son = son;
    }

    @Override
    public void findLover() {
        System.out.println("父母找了媒婆。");
        this.son.findLover();
        System.out.println("父母要求：XXXX");
    }
}
