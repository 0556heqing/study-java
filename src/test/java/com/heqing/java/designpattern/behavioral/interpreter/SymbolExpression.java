package com.heqing.java.designpattern.behavioral.interpreter;

import java.util.HashMap;

/**
 * @author heqing
 * @date 2021/12/27 11:22
 */
public abstract class SymbolExpression extends Expression {

    protected Expression left;
    protected Expression right;

    public SymbolExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public abstract int interpreter(HashMap<String, Integer> var);

}
