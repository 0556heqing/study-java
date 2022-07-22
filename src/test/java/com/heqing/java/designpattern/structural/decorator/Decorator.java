package com.heqing.java.designpattern.structural.decorator;

/**
 * @author heqing
 * @date 2021/12/23 15:42
 */
public abstract class Decorator implements Tea {

    private Tea tea;

    public Decorator(Tea tea) {
        this.tea = tea;
    }

    public void show() {
        tea.show();
    }
}
