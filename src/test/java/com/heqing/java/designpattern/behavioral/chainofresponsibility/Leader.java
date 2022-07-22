package com.heqing.java.designpattern.behavioral.chainofresponsibility;

/**
 * @author heqing
 * @date 2021/12/24 10:31
 */
public abstract class Leader {

    private Leader next;

    public void setNext(Leader next) {
        this.next = next;
    }

    public Leader getNext() {
        return next;
    }

    //处理请求的方法
    abstract void handleRequest(int LeaveDays);

}
