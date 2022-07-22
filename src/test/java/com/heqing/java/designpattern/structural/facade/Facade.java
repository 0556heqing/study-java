package com.heqing.java.designpattern.structural.facade;

/**
 * @author heqing
 * @date 2021/12/23 17:01
 */
public class Facade {

    public void active() {
        // 在内部实现的时候，可能会调用到内部的多个模块
        Window window = new Window();
        Department department = new Department();

        window.register();
        department.inquiry();
        window.pay();
    }
}
