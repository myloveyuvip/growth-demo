package com.yuliyao.growthdemo.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author yuliyao
 * @date 2018/12/30
 * 媒婆
 */
public class MatchMaker implements InvocationHandler {


    private Object target;

    public MatchMaker(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是媒婆，我来给你介绍对象~");
        Object result = method.invoke(target, args);
        System.out.println("媒婆：介绍合适，请抓紧办事！");
        return result;
    }
}
