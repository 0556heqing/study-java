package com.heqing.java.designpattern.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author heqing
 * @date 2021/12/24 16:54
 */
public class Game implements Subject {

    private List<Observer> playerList = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        playerList.add(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer : playerList) {
            observer.update(message);
        }
    }
}
