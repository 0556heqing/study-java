package com.heqing.java.designpattern.behavioral.chainofresponsibility;

/**
 * @author heqing
 * @date 2021/12/24 10:33
 */
public class DepartmentHead extends Leader {

    public void handleRequest(int LeaveDays) {
        if (LeaveDays <= 7) {
            System.out.println("系主任批准您请假" + LeaveDays + "天。");
        } else {
            if (getNext() != null) {
                System.out.println("系主任说，请假天数太多，找下一个人签吧！");
                getNext().handleRequest(LeaveDays);
            } else {
                System.out.println("请假天数太多，系主任不同意！");
            }
        }
    }

}
