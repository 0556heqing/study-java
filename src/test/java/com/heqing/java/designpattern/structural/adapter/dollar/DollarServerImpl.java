package com.heqing.java.designpattern.structural.adapter.dollar;

/**
 * @author heqing
 * @date 2021/12/22 15:32
 */
public class DollarServerImpl implements DollarServer {

    /**
     * 该接口用于判断输入的钱是否超过10美元
     * @param dollar
     */
    @Override
    public void compareDollar(Dollar dollar) {
        if(dollar.getNum() > 10) {
            System.out.println("恭喜，超过10美元了。资产：" + dollar.getNum());
        } else {
            System.out.println("抱歉，不超过10美元。资产：" + dollar.getNum());
        }
    }
}
