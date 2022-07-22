package com.heqing.java.designpattern.behavioral.templatemethod;

/**
 * @author heqing
 * @date 2021/12/27 10:02
 */
public abstract class MobilePhone {

    public abstract void system();

    public abstract void chip();

    public void create() {
        chip();
        system();
    }

}
