package com.heqing.java.designpattern.behavioral.state;

/**
 * @author heqing
 * @date 2021/12/24 17:14
 */
public class LeadNode extends Node {

    @Override
    public void nodeHandle(Flow context) {
        System.out.println("-----领导开始审批-----");
        if(context != null && context.getStatus() == 0) {
            if(context.getDay() < 7) {
                context.setStatus(2);
                System.out.println("领导通过了");
                context.setNode(new HrNode());
            } else {
                context.setStatus(1);
                System.out.println("领导拒绝了");
            }
        }
    }
}
