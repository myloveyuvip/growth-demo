package com.yuliyao.growthdemo.proxy.jdk;

/**
 * @author yuliyao
 * @date 2018/12/30
 */
public class Zhangsan implements IPerson{
    @Override
    public void findLove() {
        System.out.println("张三：我要寻找真爱！");
    }
}
