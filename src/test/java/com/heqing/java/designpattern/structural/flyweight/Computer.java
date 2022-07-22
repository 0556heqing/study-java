package com.heqing.java.designpattern.structural.flyweight;

/**
 * @author heqing
 * @date 2021/12/23 18:28
 */
public abstract class Computer {

    protected String studentName;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
