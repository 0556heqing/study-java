package com.heqing.java.designpattern.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author heqing
 * @date 2021/12/24 13:54
 */
public class ConcreteMyList implements IMyList {

    private List<Object> list = new ArrayList<>();

    public void add(Object o) {
        list.add(o);
    }

    public void remove(Object o) {
        list.remove(o);
    }

    public Iterator iterator() {
        return new ConcreteIterator(list);
    }

}
