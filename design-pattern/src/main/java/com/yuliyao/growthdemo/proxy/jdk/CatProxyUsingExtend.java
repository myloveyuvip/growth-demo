package com.yuliyao.growthdemo.proxy.jdk;

/**
 * @author YuLiyao
 * @date 2020/12/20
 */
public class CatProxyUsingExtend extends Cat {

    @Override
    public void eat() {
        System.out.println("我是代理，我帮你找食物");
        super.eat();
        System.out.println("吃完还能帮你收拾");
    }
}
