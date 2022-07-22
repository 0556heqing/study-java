package com.heqing.java.designpattern.behavioral.visitor;

import java.util.List;

/**
 * @author heqing
 * @date 2021/12/27 10:19
 */
public class BusinessReport {

    private List<Staff> mStaffs;

    public BusinessReport(List<Staff> mStaffs) {
        this.mStaffs = mStaffs;
    }

    /**
     * 为访问者展示报表
     * @param visitor 公司高层，如CEO、CTO
     */
    public void showReport(Visitor visitor) {
        for (Staff staff : mStaffs) {
            staff.accept(visitor);
        }
    }
}
