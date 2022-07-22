package com.heqing.java.designpattern.behavioral.chainofresponsibility;

import org.junit.jupiter.api.Test;

/**
 * 职责链模式是一种行为型模式。
 * 定义：为了避免请求发送者与多个请求处理者耦合在一起，于是将所有请求的处理者通过前一对象记住其下一个对象的引用而连成一条链；当有请求发生时，可将请求沿着这条链传递，直到有对象处理它为止。
 *
 * @author heqing
 * @date 2021/12/24 10:13
 */
public class TestChainOfResponsibility {

    @Test
    public void testChainOfResponsibility() {
        // 假如规定学生请假小于或等于 3 天，班主任可以批准；小于或等于 7 天，系主任可以批准；小于或等于 15 天，院长可以批准；其他情况不予批准；

        // 班主任来了
        Leader classAdviser = new ClassAdviser();
        // 系主任来了
        Leader departmentHead = new DepartmentHead();
        // 院长来了
        Leader dean = new Dean();

        // 组装责任链
        // 班主任后面是系主任
        classAdviser.setNext(departmentHead);
        // 系主任后面是院长
        departmentHead.setNext(dean);

        // 向班主任请假10天
        classAdviser.handleRequest(10);
    }
}
