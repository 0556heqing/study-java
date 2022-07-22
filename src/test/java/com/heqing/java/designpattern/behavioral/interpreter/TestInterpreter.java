package com.heqing.java.designpattern.behavioral.interpreter;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * 解释器模式是一种行为型模式。
 * 给定一个语言，定义它的文法的一种表示，并定义一个解释器，这个解释器使用该表示来解释语言中的句子
 *
 * @author heqing
 * @date 2021/12/24 10:16
 */
public class TestInterpreter {

    @Test
    public void testInterpreter() {
        Calculator calculator = new Calculator("a-b+c");
        HashMap<String, Integer> var = new HashMap();
        var.put("a", 1);
        var.put("b", 3);
        var.put("c", 5);
        int num = calculator.run(var);
        System.out.println("num = " + num);
    }
}
