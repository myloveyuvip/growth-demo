package com.yuliyao.growthdemo.proxy.jdk;

import org.checkerframework.checker.units.qual.C;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author YuLiyao
 * @date 2020/12/20
 */
public class CatProxyMain {

    public static void main(String[] args) {
       //使用继承方式的代码
        Cat cat = new CatProxyUsingExtend();
        cat.eat();

        //使用接口方式的代理
        Cat cat1 = new Cat();
        CatProxyUsingImplement catProxyUsingImplement = new CatProxyUsingImplement(cat1);
        catProxyUsingImplement.eat();

        //使用半动态代理（自己瞎写的嘿嘿）
        MyInvocationHandler invocation = (method, args1, proxy) -> {
            System.out.println("我是动态代理，我帮你找食物");

            Object result = null;
            try {
                result = method.invoke(cat1, args1);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            System.out.println("吃完还能帮你收拾");
            return result;
        };
        CatDynamicProxyUsingImplement dynamicProxyUsingImplement = new CatDynamicProxyUsingImplement(invocation);
        dynamicProxyUsingImplement.eat();
        //使用JDK的动态代理
        Cat cat2 = new Cat();
        InvocationHandler invocationHandler = (proxy, method, args12) -> {
            System.out.println("我是JDK动态代理，我帮你找食物");
            Object result = method.invoke(cat2, args12);
            System.out.println("吃完还能帮你收拾");
            return result;
        };
        Animal proxyInstance = (Animal) Proxy.newProxyInstance(Animal.class.getClassLoader(), Cat.class.getInterfaces(),
                invocationHandler);
        proxyInstance.eat();
    }
}
