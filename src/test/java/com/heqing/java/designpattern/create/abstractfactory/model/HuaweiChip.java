package com.heqing.java.designpattern.create.abstractfactory.model;

/**
 * @author heqing
 * @date 2021/12/22 14:41
 */
public class HuaweiChip implements Chip {

    @Override
    public void name() {
        System.out.println("  麒麟 芯片");
    }
}
