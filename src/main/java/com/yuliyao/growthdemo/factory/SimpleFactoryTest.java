package com.yuliyao.growthdemo.factory;

/**
 * @author YuLiyao
 * @date 2019/1/28
 */
public class SimpleFactoryTest {

    public static void main(String[] args) {
        Car car = SimpleFactory.getCar("bmw");
        car.drive();
    }
}
