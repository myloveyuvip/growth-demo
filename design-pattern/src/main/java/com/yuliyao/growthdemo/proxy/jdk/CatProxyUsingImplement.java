package com.yuliyao.growthdemo.proxy.jdk;

/**
 * @author YuLiyao
 * @date 2020/12/20
 */
public class CatProxyUsingImplement implements Animal{

    private final Cat cat;

    public CatProxyUsingImplement(Cat cat) {
        this.cat = cat;
    }

    @Override
    public void eat() {
        System.out.println("我是代理，我帮你找食物");
        cat.eat();
        System.out.println("吃完还能帮你收拾");
    }
}
