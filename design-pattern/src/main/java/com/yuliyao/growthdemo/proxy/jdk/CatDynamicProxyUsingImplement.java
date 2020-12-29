package com.yuliyao.growthdemo.proxy.jdk;

import java.lang.reflect.Method;

/**
 * @author YuLiyao
 * @date 2020/12/20
 */
public class CatDynamicProxyUsingImplement implements Animal{

    MyInvocationHandler myInvocationHandler;

    public CatDynamicProxyUsingImplement(MyInvocationHandler myInvocationHandler) {
        this.myInvocationHandler = myInvocationHandler;
    }

    @Override
    public void eat() {
        try {
            Method method = Animal.class.getMethod("eat", null);
            myInvocationHandler.invoke(method, null, this);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

}
