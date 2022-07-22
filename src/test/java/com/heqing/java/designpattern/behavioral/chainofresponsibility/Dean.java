package com.heqing.java.designpattern.behavioral.chainofresponsibility;

/**
 * @author heqing
 * @date 2021/12/24 10:35
 */
public class Dean extends Leader {

    public void handleRequest(int LeaveDays) {
        if (LeaveDays <= 15) {
            System.out.println("院长批准您请假" + LeaveDays + "天。");
        } else {
            if (getNext() != null) {
                getNext().handleRequest(LeaveDays);
            } else {
                System.out.println("请假天数太多，院长不同意！");
            }
        }
    }
}
