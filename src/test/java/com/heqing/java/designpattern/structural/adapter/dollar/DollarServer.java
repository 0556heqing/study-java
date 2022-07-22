package com.heqing.java.designpattern.structural.adapter.dollar;

/**
 * @author heqing
 * @date 2021/12/22 15:40
 */
public interface DollarServer {

    /**
     * 该接口用于判断输入的钱是否超过10美元
     * @param dollar
     */
    void compareDollar(Dollar dollar);
}
