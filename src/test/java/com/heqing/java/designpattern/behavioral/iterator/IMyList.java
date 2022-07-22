package com.heqing.java.designpattern.behavioral.iterator;

/**
 * @author heqing
 * @date 2021/12/24 13:53
 */
public interface IMyList {

    void add(Object o);

    void remove(Object o);

    Iterator iterator();

}
