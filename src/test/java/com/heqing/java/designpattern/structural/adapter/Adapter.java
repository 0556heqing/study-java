package com.heqing.java.designpattern.structural.adapter;

import com.heqing.java.designpattern.structural.adapter.dollar.Dollar;
import com.heqing.java.designpattern.structural.adapter.dollar.DollarServerImpl;
import com.heqing.java.designpattern.structural.adapter.rmb.Rmb;
import com.heqing.java.designpattern.structural.adapter.rmb.RmbServer;

/**
 * 类适配：继承想用的方法，重新实现拥有的方法
 *
 * @author heqing
 * @date 2021/12/22 15:52
 */
public class Adapter extends DollarServerImpl implements RmbServer {

    @Override
    public void compareRmb(Rmb rmb) {
        // 人民币与美元汇率大概是 6.3705
        double dollarNum = rmb.getNum() / 6.3705;
        Dollar dollar = new Dollar(dollarNum);
        compareDollar(dollar);
    }
}
