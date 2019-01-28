package com.yuliyao.growthdemo.factory;

/**
 * @author YuLiyao
 * @date 2019/1/28
 * 简单工厂：方便调用方，但是扩展需要改代码。
 */
public class SimpleFactory {


    public static Car getCar(String car) {
        if (car.equals("benz")) {
            return new Benz();
        } else if (car.equals("bmw")) {
            return new Bmw();
        } else if (car.equals("audi")) {
            return new Audi();
        } else {
            System.out.println("我给不了你要的");
            return null;
        }

    }
}
