package com.heqing.java.designpattern.behavioral.memento;

/**
 * @author heqing
 * @date 2021/12/24 15:55
 */
public class Originator {

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Memento createMemento() {
        return new Memento(msg);
    }
    public void restoreMemento(Memento m) {
        this.setMsg(m.getMsg());
    }
}
