package com.yuliyao.growthdemo.proxy.jdk;

import com.yuliyao.growthdemo.proxy.jdk.Animal;

/**
 * @author yuliyao
 * @date 2018/12/30
 */
public class Cat implements Animal {

    @Override
    public void eat() {
        System.out.println("我是小猫，我会吃！");
    }
}
