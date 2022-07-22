package com.heqing.java.designpattern.behavioral.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @author heqing
 * @date 2021/12/24 15:57
 */
public class Caretaker {

    private List<Memento> mementoList = new ArrayList<>();

    public void addMemento(Memento m) {
        mementoList.add(m);
    }
    public Memento getMemento(int num) {
        return mementoList.get(num);
    }

}
