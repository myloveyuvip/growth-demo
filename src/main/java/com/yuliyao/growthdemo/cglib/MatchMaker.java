package com.yuliyao.growthdemo.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author yuliyao
 * @date 2019/1/17
 */
public class MatchMaker implements MethodInterceptor {

    private Object targetObject;

    public Object createObject(Object object) {
        this.targetObject = object;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.targetObject.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }




    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("我是cglib的媒婆，我来帮你物色对象！");
        Object object = methodProxy.invoke(this.targetObject, objects);
        System.out.println("我是cglib的媒婆，我还能帮你善后！");
        return object;
    }
}
