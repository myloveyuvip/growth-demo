package com.yuliyao.growthdemo.proxy.jdk.custom;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author yuliyao
 * @date 2019/1/1
 */
public class MatchMaker implements LYInvocationHandler{

    private Object target;

    public MatchMaker(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Method method, Object target, Object... args) {
        Object result = null;
        try {
            result = method.invoke(target, args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }
}
