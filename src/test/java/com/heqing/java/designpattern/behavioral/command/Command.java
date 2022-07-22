package com.heqing.java.designpattern.behavioral.command;

/**
 * @author heqing
 * @date 2021/12/24 11:29
 */
public abstract class Command {

    private Army army;

    public Command(Army army) {
        this.army = army;
    }

    public Army getArmy() {
        return army;
    }

    public void setArmy(Army army) {
        this.army = army;
    }

    abstract void execute();
}
