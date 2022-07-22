package com.heqing.java.designpattern.behavioral.memento;

/**
 * @author heqing
 * @date 2021/12/24 15:43
 */
public class Memento {

    public Memento(String msg) {
        this.msg = msg;
    }

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
