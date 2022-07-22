package com.heqing.java.designpattern.behavioral.visitor;

/**
 * @author heqing
 * @date 2021/12/27 10:14
 */
public class Engineer extends Staff {

    private int codeLines;

    public Engineer(String name, int codeLines) {
        super(name);

        this.codeLines = codeLines;
        float kpi = (float)this.codeLines / 10000;
        this.setKpi(kpi);
    }

    public int getCodeLines() {
        return codeLines;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
