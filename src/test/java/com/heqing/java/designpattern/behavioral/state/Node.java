package com.heqing.java.designpattern.behavioral.state;

/**
 * @author heqing
 * @date 2021/12/24 17:10
 */
public abstract class Node {

    private static String name; //当前节点名称

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    //节点跳转
    public abstract void nodeHandle(Flow context);
}
