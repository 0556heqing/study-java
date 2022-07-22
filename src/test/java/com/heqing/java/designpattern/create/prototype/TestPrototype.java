package com.heqing.java.designpattern.create.prototype;

import org.junit.jupiter.api.Test;

/**
 * 原型模式是一种对象创建型模式，用原型实例指定创建对象的种类，并且通过复制这些原型创建新的对象。
 * 原型模式允许一个对象在创建另一个一个可定制对象，无需指导创建细节。
 *
 * 实现方式：
 *  1.在派生类中实现Cloneable接口
 *  2.在派生类中覆盖基类的clone()方法，并声明为public；
 *  3.在派生类的clone方法中，调用super.clone();
 *  注意：一个类包含一些成员对象，在使用原型模式克隆对象时，根据其成员对象是否也克隆，原型模式可分为两种形式，浅克隆和深克隆。
 *
 * @author heqing
 * @date 2021/12/21 10:00
 */
public class TestPrototype {

    @Test
    public void testQianClone() {
        QianClone qian = new QianClone();
        qian.setName("浅克隆");
        Address address = new Address("安徽", "安庆");
        qian.setAddress(address);

        QianClone qianClone = (QianClone)qian.clone();
        qianClone.getAddress().setProvince("上海");

        System.out.println("qian :" + qian);
        System.out.println("qianCopy :" + qianClone);
        // 注意：浅拷贝中，原对象中的address也被修改为上海，说明 address 为同一对象
        System.out.println("address是否同一对象: " + (qian.getAddress() == qianClone.getAddress()));
    }

    @Test
    public void testShenClone()  {
        ShenClone shen = new ShenClone();
        shen.setName("深克隆");
        shen.setAddress(new Address("安徽", "安庆"));

        ShenClone shenClone = (ShenClone)shen.clone();
        shenClone.getAddress().setProvince("上海");

        System.out.println("shenClone :" + shen);
        System.out.println("shenCopy :" + shenClone);
        // 注意：深拷贝中，原对象中的address没有被修改，说明 address 为不是同一对象
        System.out.println("address是否同一对象: " + (shen.getAddress() == shenClone.getAddress()));
    }
}
