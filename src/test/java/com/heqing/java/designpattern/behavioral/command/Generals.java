package com.heqing.java.designpattern.behavioral.command;

/**
 * @author heqing
 * @date 2021/12/24 11:25
 */
public class Generals {

    Command gu, jin;

    public void setGu(Command gu) {
        this.gu = gu;
    }

    public void setJin(Command jin) {
        this.jin = jin;
    }

    public void releaseGu() {
        gu.execute();
    }

    public void releaseJin() {
        jin.execute();
    }
}
