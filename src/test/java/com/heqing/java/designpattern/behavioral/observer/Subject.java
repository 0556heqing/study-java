package com.heqing.java.designpattern.behavioral.observer;

/**
 * @author heqing
 * @date 2021/12/24 16:53
 */
public interface Subject {

    /**
     * 增加订阅者
     * @param observer
     */
    void attach(Observer observer);

    /**
     * 通知订阅者更新消息
     */
    void notify(String message);

}
