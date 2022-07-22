package com.heqing.java.designpattern.behavioral.interpreter;

import java.util.HashMap;

/**
 * @author heqing
 * @date 2021/12/27 11:20
 */
public abstract class Expression {

    //解析公式和数值，key是公式中的参数，value是具体的数值
    public abstract int interpreter(HashMap<String, Integer> var);

}
