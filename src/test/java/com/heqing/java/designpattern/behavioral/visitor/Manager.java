package com.heqing.java.designpattern.behavioral.visitor;

/**
 * @author heqing
 * @date 2021/12/27 10:15
 */
public class Manager extends Staff {

    private int products;

    public Manager(String name, int products) {
        super(name);

        this.products = products;
        float kpi = (float)this.products / 5;
        this.setKpi(kpi);
    }

    public int getProducts() {
        return products;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
