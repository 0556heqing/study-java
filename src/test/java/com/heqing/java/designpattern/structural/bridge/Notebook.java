package com.heqing.java.designpattern.structural.bridge;

import com.heqing.java.designpattern.structural.bridge.brand.Brand;

/**
 * @author heqing
 * @date 2021/12/22 21:17
 */
public class Notebook extends Computer {

    public Notebook(Brand brand) {
        super(brand);
    }

    @Override
    public void model() {
        System.out.println(brand.name() + " 笔记本电脑");
    }
}
