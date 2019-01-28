package com.yuliyao.growthdemo.factory;

/**
 * @author YuLiyao
 * @date 2019/1/28
 */
public class FactoryMethodTest {

    public static void main(String[] args) {
        //要奔驰车，就去奔驰方法
        BenzFactory benzFactory = new BenzFactory();
        benzFactory.getCar().drive();
        //要宝马车，就去宝马方法拿
        BmwFactory bmwFactory = new BmwFactory();
        bmwFactory.getCar().drive();

    }
}
