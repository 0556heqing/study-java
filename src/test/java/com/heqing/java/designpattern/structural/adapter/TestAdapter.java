package com.heqing.java.designpattern.structural.adapter;

import com.heqing.java.designpattern.structural.adapter.dollar.Dollar;
import com.heqing.java.designpattern.structural.adapter.dollar.DollarServer;
import com.heqing.java.designpattern.structural.adapter.dollar.DollarServerImpl;
import com.heqing.java.designpattern.structural.adapter.rmb.Rmb;
import com.heqing.java.designpattern.structural.adapter.rmb.RmbServer;
import com.heqing.java.designpattern.structural.adapter.rmb.RmbServerImpl;
import org.junit.jupiter.api.Test;

/**
 * 适配器模式是一种结构型设计模式。
 *
 * 定义：把一个类的接口变换成客户端所期待的另一种接口，从而使原本接口不匹配而无法一起工作的两个类能够在一起工作。
 * 目的（本质：转换匹配，复用功能）
 * 是复用已有的功能，而不是来实现新的接口。能使接口不兼容的对象相互合作。
 *
 * 适配器模式结构和说明
 * Client：客户端，调用需要的接口Taget
 * Taget：定义客户端需要的特定领域相关的接口
 * Adaptee：已经存在的实现类，通常能满足客户端的功能要求，但是接口与客户端要求的参数类型或个数不匹配，需要适配
 * Adapter：适配器，把Adaptee适配成Client需要的Taget
 *
 * 类适配器：使用对象继承的方式，是静态的定义方式。
 *      由于继承了Adaptee，因此不能同Adaptee子类一起工作，但是可以重定义Adaptee的部分方法。
 * 对象适配器：使用对象组合的方式，是动态实现方式。
 *      组合关系，可以同Adaptee子类一起工作，重新定义方法困难。可以考虑与代理
 *
 * 优点：复用性、扩展性
 * 缺点：过多使用，系统过于零散，不易把握
 *
 * @author heqing
 * @date 2021/12/22 15:18
 */
public class TestAdapter {

    // 假设我有100元人民币
    Rmb rmb = new Rmb(100);
    RmbServer rmbServer = new RmbServerImpl();

    // 假设我有5美元
    Dollar dollar = new Dollar(5);
    DollarServer dollarServer = new DollarServerImpl();

    @Test
    public void testAdapter() {
        // 我可以比较是否超过50元人民币
        rmbServer.compareRmb(rmb);

        // 我可以比较是否超过10美元
        dollarServer.compareDollar(dollar);

        System.out.println("--- 现在想用人民币比较是否超过10美元,但是比较接口只接受美元怎么办？ ---");

        // 制定一个adapter适配接口。。各种货币都能跟美元比较
        Adapter adapter = new Adapter();
        // 我现在能输入人民币比较美元了
        adapter.compareRmb(rmb);
        // 同样的类我也能直接输入美元比较了
        adapter.compareDollar(dollar);
    }

    @Test
    public void testTwoDirectAdapter() {
        System.out.println("--- 现在想用各种货币互相比较怎么办？ ---");

        // 双向适配器
        TwoDirectAdapter twoDirectAdapter = new TwoDirectAdapter(rmbServer, dollarServer);
        // 各种货币都能互相比较
        System.out.println("--- 各种货币跟人民币比较 ---");
        twoDirectAdapter.compareRmb(rmb);
        twoDirectAdapter.compareRmb(dollar);
        System.out.println("--- 各种货币跟美元比较 ---");
        twoDirectAdapter.compareDollar(rmb);
        twoDirectAdapter.compareDollar(dollar);
    }
}
