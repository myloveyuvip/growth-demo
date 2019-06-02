package com.yuliyao.growthdemo.factory;

/**
 * @author YuLiyao
 * @date 2019/1/28
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {

        DefaultFacotry defaultFacotry = new DefaultFacotry();
        defaultFacotry.getCar("bmw").drive();

    }
}
