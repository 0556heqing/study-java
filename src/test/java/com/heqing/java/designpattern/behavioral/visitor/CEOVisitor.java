package com.heqing.java.designpattern.behavioral.visitor;

/**
 * @author heqing
 * @date 2021/12/27 10:16
 */
public class CEOVisitor implements Visitor {

    @Override
    public void visit(Engineer engineer) {
        System.out.println("工程师: " + engineer.getName() + ", KPI: " + engineer.getKpi());
    }

    @Override
    public void visit(Manager manager) {
        System.out.println("产品经理: " + manager.getName() + ", KPI: " + manager.getKpi());
    }
}
