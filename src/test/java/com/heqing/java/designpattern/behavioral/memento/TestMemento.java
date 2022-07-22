package com.heqing.java.designpattern.behavioral.memento;

import org.junit.jupiter.api.Test;

/**
 * 备忘录模式是一种行为型模式。
 * 在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态，以便以后当需要时能将该对象恢复到原先保存的状态
 *
 * @author heqing
 * @date 2021/12/24 10:17
 */
public class TestMemento {

    @Test
    public void testMemento() {
        // 下载一个代码版本管理工具，比如:git
        Caretaker git = new Caretaker();
        // 有一个程序员
        Originator cxy = new Originator();
        // 写了一行代码
        cxy.setMsg("Hello world");
        // 提交到代码库。相当于先add再commit
        git.addMemento(cxy.createMemento());
        // 又写了一行代码，再提交到代码库
        cxy.setMsg("this is bug");
        git.addMemento(cxy.createMemento());

        // 检查下自己写的什么
        System.out.println(cxy.getMsg());
        // 我靠,这个一个bug，赶紧回滚到上次的提交
        cxy.restoreMemento(git.getMemento(0));
        // 再看看写了什么
        System.out.println("第一次提交：" + cxy.getMsg());
        // 还是再回滚到最新版本的去改bug吧，不然都白写了
        cxy.restoreMemento(git.getMemento(1));
        // 看看怎么改这个bug
        System.out.println("第二次提交：" + cxy.getMsg());
    }
}
