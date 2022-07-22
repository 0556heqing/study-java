package com.heqing.java.designpattern.behavioral.iterator;

import org.junit.jupiter.api.Test;

/**
 * 迭代器模式是一种行为型模式。
 * 定义：提供一种方法顺序访问一个聚合对象中的各个元素，而不是暴露其内部的表示
 *
 * @author heqing
 * @date 2021/12/24 10:16
 */
public class TestIterator {

    @Test
    public void testIterator() {
        IMyList list = new ConcreteMyList();
        list.add("1");
        list.add("2");
        list.add("3");

        Iterator it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
