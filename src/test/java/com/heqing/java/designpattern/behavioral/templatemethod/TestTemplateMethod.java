package com.heqing.java.designpattern.behavioral.templatemethod;

import org.junit.jupiter.api.Test;

/**
 * 模板方法模式是一种行为型模式。
 *
 * @author heqing
 * @date 2021/12/24 10:18
 */
public class TestTemplateMethod {

    @Test
    public void testTemplateMethod() {
        MobilePhone mobilePhone = new HuaweiPhone();
        mobilePhone.create();

        System.out.println("--------------------");

        mobilePhone = new ApplePhone();
        mobilePhone.create();
    }
}
