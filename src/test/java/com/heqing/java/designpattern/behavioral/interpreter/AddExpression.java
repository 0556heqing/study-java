package com.heqing.java.designpattern.behavioral.interpreter;

import java.util.HashMap;

/**
 * @author heqing
 * @date 2021/12/27 11:24
 */
public class AddExpression extends SymbolExpression {

    public AddExpression(Expression left, Expression right) {
        super(left, right);
    }

    public int interpreter(HashMap<String, Integer> var) {
        return super.left.interpreter(var) + super.right.interpreter(var);
    }

}
