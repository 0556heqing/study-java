package com.heqing.java.proxy;

/**
 * @author heqing
 * @date 2021/8/16 17:40
 */
public class UserDaoImpl implements UserDao {

    @Override
    public void save() {
        System.out.println("保存数据方法");
    }
}