package com.heqing.java.designpattern.structural.adapter;

import com.heqing.java.designpattern.structural.adapter.dollar.Dollar;
import com.heqing.java.designpattern.structural.adapter.dollar.DollarServer;
import com.heqing.java.designpattern.structural.adapter.rmb.Rmb;
import com.heqing.java.designpattern.structural.adapter.rmb.RmbServer;

/**
 * 对象适配：继承想用的接口，引入实现的对象，通过对象调用相应的方法
 *
 * @author heqing
 * @date 2022/1/6 18:11
 */
public class TwoDirectAdapter implements RmbServer, DollarServer {

    RmbServer rmbServer;
    DollarServer dollarServer;

    public TwoDirectAdapter(RmbServer rmbServer, DollarServer dollarServer) {
        this.rmbServer = rmbServer;
        this.dollarServer = dollarServer;
    }

    public void compareDollar(Rmb rmb) {
        // 人民币与美元汇率大概是 6.3705
        double dollarNum = rmb.getNum() / 6.3705;
        Dollar dollar = new Dollar(dollarNum);
        dollarServer.compareDollar(dollar);
    }

    public void compareRmb(Dollar dollar) {
        // 人民币与美元汇率大概是 6.3705
        double dollarNum = dollar.getNum() * 6.3705;
        Rmb rmb = new Rmb(dollarNum);
        rmbServer.compareRmb(rmb);
    }

    @Override
    public void compareDollar(Dollar dollar) {
        dollarServer.compareDollar(dollar);
    }

    @Override
    public void compareRmb(Rmb rmb) {
        rmbServer.compareRmb(rmb);
    }
}