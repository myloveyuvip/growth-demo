package com.yuliyao.growthdemo.factory;

/**
 * @author YuLiyao
 * @date 2019/1/28
 */
public class Audi implements Car {

    @Override
    public void drive() {
        System.out.println("我是奥迪，我要迪奥！");
    }
}
