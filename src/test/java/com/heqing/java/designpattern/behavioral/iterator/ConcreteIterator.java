package com.heqing.java.designpattern.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author heqing
 * @date 2021/12/24 13:55
 */
public class ConcreteIterator implements Iterator {

    private List<Object> list = new ArrayList<>();

    private int cursor = 0;

    public ConcreteIterator(List<Object> list) {
        this.list = list;
    }

    public Object next() {
        Object o = null;
        if (this.hasNext()) {
            o = list.get(cursor++);
        }
        return o;
    }

    public boolean hasNext() {
        if (cursor == list.size()) {
            return false;
        }
        return true;
    }
}
