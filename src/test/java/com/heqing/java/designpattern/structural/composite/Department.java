package com.heqing.java.designpattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author heqing
 * @date 2021/12/23 14:43
 */
public class Department extends Organization {

    private List<Organization> organizationList;

    public Department(String name){
        super(name);
        organizationList = new ArrayList<>();
    }

    /**
     * 浏览部门情况
     */
    public void display() {
        System.out.println(super.getName());
        for(Organization organization : organizationList){
            if(organization instanceof Staff) {
                System.out.print("  ");
            }
            System.out.print(super.getName()  + "包含：");
            organization.display();
        }
    }

    /**
     * @desc 向部门中添加下级部门
     * @param organization
     * @return void
     */
    public void add(Organization organization){
        organizationList.add(organization);
    }
}
