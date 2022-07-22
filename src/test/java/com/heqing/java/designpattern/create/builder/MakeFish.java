package com.heqing.java.designpattern.create.builder;

/**
 * @author heqing
 * @date 2021/12/21 18:24
 */
public class MakeFish implements MakeFood {

    @Override
    public void prepareFood() {
        System.out.println("去菜市场买鱼");
    }

    @Override
    public void fryFood() {
        System.out.println("做一个鱼汤");
    }

    @Override
    public void eatFood() {
        System.out.println("汤做好了，快来喝鱼汤");
    }
}
