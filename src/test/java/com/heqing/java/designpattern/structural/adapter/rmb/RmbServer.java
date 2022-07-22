package com.heqing.java.designpattern.structural.adapter.rmb;

/**
 * @author heqing
 * @date 2021/12/22 15:49
 */
public interface RmbServer {

    /**
     * 该接口用于判断输入的钱是否超过10元人民币
     * @param rmb
     */
    void compareRmb(Rmb rmb);
}
