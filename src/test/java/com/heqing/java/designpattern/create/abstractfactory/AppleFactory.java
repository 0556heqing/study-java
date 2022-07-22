package com.heqing.java.designpattern.create.abstractfactory;

import com.heqing.java.designpattern.create.abstractfactory.model.AppleChip;
import com.heqing.java.designpattern.create.abstractfactory.model.AppleSystem;

/**
 * @author heqing
 * @date 2021/12/22 14:48
 */
public class AppleFactory implements MobilePhoneFactory {

    @Override
    public AppleSystem createSystem() {
        return new AppleSystem();
    }

    @Override
    public AppleChip createChip() {
        return new AppleChip();
    }

    @Override
    public void make() {
        System.out.println("苹果工厂 开始生产：" );
        createSystem().name();
        createChip().name();
    }
}
