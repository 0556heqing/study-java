package com.heqing.java.designpattern.behavioral.observer;

import org.junit.jupiter.api.Test;

/**
 * 观察者模式是一种行为型模式。
 * 定义了一种一对多的依赖关系，让多个观察者对象同时监听某一个主题对象。
 * 这个主题对象在状态变化时，会通知所有的观察者对象，使他们能够自动更新自己。
 *
 * @author heqing
 * @date 2021/12/24 10:17
 */
public class TestObserver {

    @Test
    public void testObserver() {
        // 有两个玩家
        Player player1 = new Player("玩家A");
        Player player2 = new Player("玩家B");
        // 有一个游戏,正在更新
        Game game = new Game();
        // 玩家订阅了游戏
        game.attach(player1);
        game.attach(player2);

        // 游戏正在更新
        game.notify("正在更新中");
        // 更新完了，兄弟们快去玩游戏啊
        game.notify("更新完成");
    }

}
