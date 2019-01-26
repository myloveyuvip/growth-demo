package com.yuliyao.growthdemo.singleton;

/**
 * @author yuliyao
 * @date 2019/1/26
 */
public class SingletonDemoTest {

    public static void main(String[] args) {
        SingletonDemo instance = SingletonDemo.getInstance();
        SingletonDemo instance2 = SingletonDemo.getInstance();
        System.out.println(instance);
        System.out.println(instance2);
    }
}
