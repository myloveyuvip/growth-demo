package com.yuliyao.growthdemo.proxy.jdk.custom;

import java.lang.reflect.Method;

/**
 * @author yuliyao
 * @date 2018/12/31
 */
public interface LYInvocationHandler {

    /**
     * 调用方法
     * @param method
     * @param target
     * @param args
     * @return
     */
    Object invoke(Method method,Object target, Object... args);

}
