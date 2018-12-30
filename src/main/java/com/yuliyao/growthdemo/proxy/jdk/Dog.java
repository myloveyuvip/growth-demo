package com.yuliyao.growthdemo.proxy.jdk;

/**
 * @author yuliyao
 * @date 2018/12/30
 */
public class Dog implements Animal{
    @Override
    public void eat() {
        System.out.println("我是小狗，吃谁不会！");
    }
}
