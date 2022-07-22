package com.heqing.java.designpattern.structural.composite;

import org.junit.jupiter.api.Test;

/**
 * 组合模式是一种结构型设计模式。
 * 核心模块为树状才有价值。组合模式组合多个对象形成树形结构以表示“整体-部分”的结构层次。
 *
 * @author heqing
 * @date 2021/12/23 13:45
 */
public class TestComposite {

    @Test
    public void testComposite() {
        // 员工
        Staff staff1 = new Staff("贺小白");
        Staff staff2 = new Staff("贺小黑");
        Staff staff3 = new Staff("贺小灰");

        // 部门
        Department department1 = new Department("XX公司");
        Department department2 = new Department("人事部");
        Department department3 = new Department("技术部");
        department1.add(department2);
        department1.add(department3);

        // 人员加入部门
        department2.add(staff1);
        department3.add(staff2);
        department3.add(staff3);

        // 遍历公司技术部门
        department1.display();
    }

}
