package com.heqing.java.designpattern.structural.decorator;

/**
 * @author heqing
 * @date 2021/12/23 15:39
 */
public class ActiveRedBean extends Decorator {

    public ActiveRedBean(Tea tea){
        super(tea);
    }

    @Override
    public void show() {
        super.show();
        System.out.println("加一点红豆，相思奶茶");
    }

}
