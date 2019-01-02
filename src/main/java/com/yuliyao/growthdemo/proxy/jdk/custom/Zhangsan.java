package com.yuliyao.growthdemo.proxy.jdk.custom;

/**
 * @author yuliyao
 * @date 2019/1/1
 */
public class Zhangsan implements IPerson {

    @Override
    public void findLove() {
        System.out.println("我要寻找真爱！");
    }
}
