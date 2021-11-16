package com.heqing.java.proxy;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

/**
 * @author heqing
 * @date 2021/8/16 17:41
 */
public class TestProxy {

    @Test
    public void testCglibProxy() {
        CglibProxy cglibProxy = new CglibProxy();
        UserDao userDao = (UserDao) cglibProxy.getInstance(new UserDaoImpl());
        userDao.save();
    }

    @Test
    public void testJdkProxy() {
        // 被代理对象
        UserDao userDaoImpl = new UserDaoImpl();
        JdkProxy invocationHandlerImpl = new JdkProxy(userDaoImpl);

        //类加载器
        ClassLoader loader = userDaoImpl.getClass().getClassLoader();
        Class<?>[] interfaces = userDaoImpl.getClass().getInterfaces();

        // 主要装载器、一组接口及调用处理动态代理实例
        UserDao newProxyInstance = (UserDao) Proxy.newProxyInstance(loader, interfaces, invocationHandlerImpl);
        newProxyInstance.save();
    }
}
