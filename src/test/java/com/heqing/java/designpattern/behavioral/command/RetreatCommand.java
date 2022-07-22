package com.heqing.java.designpattern.behavioral.command;

/**
 * @author heqing
 * @date 2021/12/24 11:34
 */
public class RetreatCommand extends Command {

    public RetreatCommand(Army army) {
        super(army);
    }

    @Override
    void execute() {
        getArmy().retreat();
    }
}
