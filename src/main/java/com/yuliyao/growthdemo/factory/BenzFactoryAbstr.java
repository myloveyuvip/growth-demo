package com.yuliyao.growthdemo.factory;

/**
 * @author YuLiyao
 * @date 2019/1/28
 */
public class BenzFactoryAbstr extends AbstractFactory{

    @Override
    Car getCar() {
        return new Benz();
    }
}
