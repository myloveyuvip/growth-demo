package com.yuliyao.growthdemo.proxy.jdk.custom;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author yuliyao
 * @date 2019/1/1
 */
public class MatchMaker implements LYInvocationHandler {

    private Object target;

    public MatchMaker(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Method method, Object target1, Object... args) {
        Object result = null;
        try {
            System.out.println("我是媒婆，事前我负责给你匹配合适人选！");
            result = method.invoke(target, args);
            System.out.println("事后我给你安排流程！");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }
}
