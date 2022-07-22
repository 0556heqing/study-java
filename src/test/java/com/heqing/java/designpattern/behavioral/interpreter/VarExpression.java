package com.heqing.java.designpattern.behavioral.interpreter;

import java.util.HashMap;

/**
 * @author heqing
 * @date 2021/12/27 11:21
 */
public class VarExpression extends Expression {

    private String key;

    public VarExpression(String key) {
        this.key = key;
    }

    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return var.get(this.key);
    }

}
