package com.heqing.java.designpattern.structural.proxy;

import org.junit.jupiter.api.Test;

/**
 * 代理模式是一种结构型设计模式。指为其它对象提供一种代理，以控制对这个对象的访问。
 * 代理对象在客户端和目标对象之间起到中介作用，使用代理模式主要有两个目的：一是保护目标对象，二是增强目标对象
 *
 * @author heqing
 * @date 2021/12/23 16:51
 */
public class TestProxy {

    @Test
    public void testProxy() {
        Father father = new Father(new Son());
        father.findLover();
    }
}
