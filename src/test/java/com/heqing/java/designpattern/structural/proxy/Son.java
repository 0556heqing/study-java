package com.heqing.java.designpattern.structural.proxy;

/**
 * @author heqing
 * @date 2021/12/23 20:05
 */
public class Son implements Person {

    @Override
    public void findLover() {
        System.out.println("儿子要求：xxxxxx");
    }
}
