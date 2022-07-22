package com.heqing.java.designpattern.behavioral.command;

/**
 * @author heqing
 * @date 2021/12/24 11:14
 */
public class Army {

    public void attack() {
        System.out.println("--开始进攻");
    }

    public void retreat() {
        System.out.println("--开始撤退");
    }
}
