package com.heqing.java.designpattern.behavioral.visitor;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 访问者模式是一种行为型模式。
 * 访问者模式是一种将数据操作和数据结构分离的设计模式
 *
 * @author heqing
 * @date 2021/12/24 10:19
 */
public class TestVisitor {

    @Test
    public void testVisitor() {
        // 新建一批员工，包括1个产品经理，2个程序员
        List<Staff> mStaffs = new LinkedList<>();
        mStaffs.add(new Manager("经理-A", 6));
        mStaffs.add(new Engineer("工程师-A", 15000));
        mStaffs.add(new Engineer("工程师-B", 12500));

        // 员工加入工作报表中
        BusinessReport report = new BusinessReport(mStaffs);

        // 公司有一个CEO关注KPI,一个CTO关注工作量
        CEOVisitor ceo = new CEOVisitor();
        CTOVisitor cto = new CTOVisitor();

        // CEO 通过报表检查工作
        System.out.println("=========== CEO看报表 ===========");
        report.showReport(ceo);

        // CTO 通过报表检查工作
        System.out.println("=========== CTO看报表 ===========");
        report.showReport(cto);
    }
}
