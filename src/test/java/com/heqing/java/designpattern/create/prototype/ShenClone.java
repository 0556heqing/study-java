package com.heqing.java.designpattern.create.prototype;

import com.alibaba.fastjson.JSONObject;

/**
 * 在深克隆中被复制的对象的所有普通成员变量也都含有与原来的对象相同的值，除去那些引用其他对象的变量。
 * 换言之，在深克隆中，除了对象本身被复制外，对象包含的引用也被复制，也就是其中的成员对象也被复制。
 *
 * @author heqing
 * @date 2021/12/21 10:55
 */
public class ShenClone extends Person implements Cloneable {

    @Override
    public Object clone() {
        ShenClone clone = null;
        try {
            clone = (ShenClone) super.clone();
            /**
             * 对于对象类型的数据，深度克隆的时候需要继续调用这个对象的克隆方法
             * 原因：java调用super.clone()时，是先开辟一块内存的空间，然后把实例对象的值原样拷贝过去，
             *      对于基础数据类型是没问题，但是如果是引用类型，把值拷贝过去相当于把对应的内存地址拷贝过去，
             *      也就是说，克隆后的对象实例address与原型的对象实例address指向同一块内存空间，就是同一个实例
             *      因此，想正确执行深度拷贝，必须对每一个引用类型的属性进行克隆，并重新设置，覆盖super.clone()所拷贝的值
             */
            clone.setAddress((Address) address.clone());
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
