package com.heqing.java.designpattern.behavioral.interpreter;

import java.util.HashMap;

/**
 * @author heqing
 * @date 2021/12/27 11:25
 */
public class SubExpression extends SymbolExpression {

    public SubExpression(Expression left, Expression right) {
        super(left, right);
    }

    public int interpreter(HashMap<String, Integer> var) {
        return super.left.interpreter(var) - super.right.interpreter(var);
    }

}
