package com.heqing.java.designpattern.behavioral.visitor;

/**
 * @author heqing
 * @date 2021/12/27 10:15
 */
public interface Visitor {

    // 访问工程师类型
    void visit(Engineer engineer);

    // 访问经理类型
    void visit(Manager manager);
}
