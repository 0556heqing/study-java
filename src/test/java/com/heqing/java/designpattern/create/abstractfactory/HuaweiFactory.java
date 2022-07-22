package com.heqing.java.designpattern.create.abstractfactory;

import com.heqing.java.designpattern.create.abstractfactory.model.HuaweiChip;
import com.heqing.java.designpattern.create.abstractfactory.model.HuaweiSystem;

/**
 * @author heqing
 * @date 2021/12/22 14:47
 */
public class HuaweiFactory implements MobilePhoneFactory {

    @Override
    public HuaweiSystem createSystem() {
        return new HuaweiSystem();
    }

    @Override
    public HuaweiChip createChip() {
        return new HuaweiChip();
    }

    @Override
    public void make() {
        System.out.println("华为工厂 开始生产：" );
        createSystem().name();
        createChip().name();
    }
}
