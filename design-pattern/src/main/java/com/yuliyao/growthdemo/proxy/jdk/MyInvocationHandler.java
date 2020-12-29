package com.yuliyao.growthdemo.proxy.jdk;

import java.lang.reflect.Method;

/**
 * @author YuLiyao
 * @date 2020/12/20
 */
public interface MyInvocationHandler {

    public Object invoke(Method method, Object[] args, Object proxy);
}
