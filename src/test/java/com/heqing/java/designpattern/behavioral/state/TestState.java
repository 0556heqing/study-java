package com.heqing.java.designpattern.behavioral.state;

import org.junit.jupiter.api.Test;

/**
 * 状态模式是一种行为型模式。
 * 允许一个对象在其内部状态改变时改变它的行为
 *
 * @author heqing
 * @date 2021/12/24 10:18
 */
public class TestState {

    @Test
    public void testState() {
        // 请假流程
        Flow flow = new Flow();
        flow.setMessage("生病了");
        flow.setDay(1);
        // 开始请假
        flow.start();
    }
}
