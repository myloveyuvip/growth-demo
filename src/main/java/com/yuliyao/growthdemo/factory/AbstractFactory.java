package com.yuliyao.growthdemo.factory;

/**
 * @author YuLiyao
 * @date 2019/1/28
 * 抽象工厂：保证调用方和代码方
 */
public abstract class AbstractFactory {

    abstract Car getCar();

    public static Car getCar(String car) {

        if ("bmw".equals(car)) {
            return new BmwFactory().getCar();
        } else if ("benz".equals(car)) {
            return new BenzFactory().getCar();
        } else if ("audi".equals(car)) {
            return new AudiFactory().getCar();
        } else {
            System.out.println("你要的我给不了");
            return null;
        }

    }
}
