package com.heqing.java.designpattern.behavioral.chainofresponsibility;

/**
 * @author heqing
 * @date 2021/12/24 10:31
 */
public class ClassAdviser extends Leader {

    public void handleRequest(int LeaveDays) {
        if (LeaveDays <= 3) {
            System.out.println("班主任批准您请假" + LeaveDays + "天。");
        } else {
            if (getNext() != null) {
                System.out.println("班主任说，请假天数太多，找下一个人签吧！");
                getNext().handleRequest(LeaveDays);
            } else {
                System.out.println("请假天数太多，班主任不同意！");
            }
        }
    }

}
