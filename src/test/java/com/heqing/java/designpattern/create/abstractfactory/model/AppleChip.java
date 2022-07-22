package com.heqing.java.designpattern.create.abstractfactory.model;

/**
 * @author heqing
 * @date 2021/12/22 14:42
 */
public class AppleChip implements Chip {

    @Override
    public void name() {
        System.out.println("  A13 芯片");
    }
}
