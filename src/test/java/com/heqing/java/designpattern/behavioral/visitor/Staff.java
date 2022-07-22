package com.heqing.java.designpattern.behavioral.visitor;

/**
 * @author heqing
 * @date 2021/12/27 10:12
 */
public abstract class Staff {

    public String name;
    public float kpi;

    public Staff(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public float getKpi() {
        return kpi;
    }

    public void setKpi(float kpi) {
        this.kpi = kpi;
    }

    // 核心方法，接受Visitor的访问
    public abstract void accept(Visitor visitor);
}
