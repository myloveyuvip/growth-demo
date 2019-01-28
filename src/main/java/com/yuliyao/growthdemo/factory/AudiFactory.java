package com.yuliyao.growthdemo.factory;

/**
 * @author YuLiyao
 * @date 2019/1/28
 */
public class AudiFactory implements FactoryMethod{

    @Override
    public Car getCar() {
        return new Audi();
    }
}
