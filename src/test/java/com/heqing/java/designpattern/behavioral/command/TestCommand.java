package com.heqing.java.designpattern.behavioral.command;

import org.junit.jupiter.api.Test;

/**
 * 命令模式是一种行为型模式。
 * 定义：将一个请求封装为一个对象，使发出请求的责任和执行请求的责任分割开。这样两者之间通过命令对象进行沟通，这样方便将命令对象进行储存、传递、调用、增加与管理。
 *
 * @author heqing
 * @date 2021/12/24 10:15
 */
public class TestCommand {

    @Test
    public void testCommand() {
        // 创建一只部队
        Army army = new Army();
        // 创建鼓、金。擂鼓进攻，鸣金撤退
        Command gu = new AttackCommand(army);
        Command jin = new RetreatCommand(army);
        // 创建一个将军
        Generals generals = new Generals();
        // 把鼓、金给将军
        generals.setGu(gu);
        generals.setJin(jin);

        // 将军擂鼓
        generals.releaseGu();
        // 将军鸣金
        generals.releaseJin();
    }
}
