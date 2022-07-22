package com.heqing.java.designpattern.structural.bridge;

import com.heqing.java.designpattern.structural.bridge.brand.Brand;

/**
 * @author heqing
 * @date 2021/12/22 21:19
 */
public class Desktop extends Computer {

    public Desktop(Brand brand) {
        super(brand);
    }

    @Override
    public void model() {
        System.out.println(brand.name() + " 台式电脑");
    }
}
