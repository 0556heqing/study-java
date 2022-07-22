package com.heqing.java.designpattern.structural.adapter.rmb;

/**
 * @author heqing
 * @date 2021/12/22 15:51
 */
public class RmbServerImpl implements RmbServer {

    @Override
    public void compareRmb(Rmb rmb) {
        if(rmb.getNum() > 50) {
            System.out.println("恭喜，超过50元人民币了。资产：" + rmb.getNum());
        } else {
            System.out.println("抱歉，不超过50元人民币。资产：" + rmb.getNum());
        }
    }
}
