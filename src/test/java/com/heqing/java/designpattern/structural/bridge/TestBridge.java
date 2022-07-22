package com.heqing.java.designpattern.structural.bridge;

import com.heqing.java.designpattern.structural.bridge.brand.AppleBrand;
import com.heqing.java.designpattern.structural.bridge.brand.HuaweiBrand;
import org.junit.jupiter.api.Test;

/**
 * 桥接模式是一种结构型设计模式。
 * 解决问题：将一个大类或者一系列紧密相关的类拆成抽象和实现两个独立的层次结构，从而能在开发时分别使用
 *
 * @author heqing
 * @date 2021/12/22 16:16
 */
public class TestBridge {

    @Test
    public void testBridge() {
        Computer huaweiNotebook = new Notebook(new HuaweiBrand());
        huaweiNotebook.model();

        Computer huaweiDesktop = new Desktop(new HuaweiBrand());
        huaweiDesktop.model();

        Computer appleNotebook = new Notebook(new AppleBrand());
        appleNotebook.model();

        Computer appleDesktop = new Desktop(new AppleBrand());
        appleDesktop.model();
    }

}
