package com.heqing.java.designpattern.behavioral.state;

/**
 * @author heqing
 * @date 2021/12/24 17:14
 */
public class HrNode extends Node {

    @Override
    public void nodeHandle(Flow context) {
        System.out.println("-----hr开始审批-----");
        if(context != null && context.getStatus() == 2) {
            if(context.getDay() < 3) {
                context.setStatus(3);
                System.out.println("hr通过了");
            } else {
                context.setStatus(1);
                System.out.println("hr拒绝了");
            }
        }
    }
}
