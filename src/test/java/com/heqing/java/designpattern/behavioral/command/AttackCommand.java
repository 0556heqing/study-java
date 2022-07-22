package com.heqing.java.designpattern.behavioral.command;

/**
 * @author heqing
 * @date 2021/12/24 11:33
 */
public class AttackCommand extends Command {

    public AttackCommand(Army army) {
        super(army);
    }

    @Override
    void execute() {
        getArmy().attack();
    }
}
