package com.heqing.java.designpattern.create.prototype;

import com.alibaba.fastjson.JSONObject;

/**
 * 在浅克隆中，被复制对象的所有普通成员变量都具有与原来对象相同的值，而所有的对其他对象的引用仍然指向原来的对象。
 * 也就是说，浅克隆仅仅复制所考虑的对象（按值传递的数据），不会复制它所引用的成员对象。
 *
 * @author heqing
 * @date 2021/12/21 10:46
 */
public class QianClone extends Person implements Cloneable {

    @Override
    public Object clone() {
        QianClone clone = null;
        try {
            clone = (QianClone) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    @Override
    public String toString() {
        return  JSONObject.toJSONString(this);
    }
}
