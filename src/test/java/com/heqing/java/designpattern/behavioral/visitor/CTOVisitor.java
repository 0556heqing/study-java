package com.heqing.java.designpattern.behavioral.visitor;

/**
 * @author heqing
 * @date 2021/12/27 10:17
 */
public class CTOVisitor implements Visitor {

    @Override
    public void visit(Engineer engineer) {
        System.out.println("工程师: " + engineer.getName() + ", 代码行数: " + engineer.getCodeLines());
    }

    @Override
    public void visit(Manager manager) {
        System.out.println("产品经理: " + manager.getName() + ", 产品数量: " + manager.getProducts());
    }
}
