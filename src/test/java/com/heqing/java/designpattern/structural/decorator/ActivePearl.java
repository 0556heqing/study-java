package com.heqing.java.designpattern.structural.decorator;

/**
 * @author heqing
 * @date 2021/12/23 15:50
 */
public class ActivePearl extends Decorator {

    public ActivePearl(Tea tea){
        super(tea);
    }

    @Override
    public void show() {
        super.show();
        System.out.println("加一点珍珠，珍珠奶茶");
    }

}
