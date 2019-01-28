package com.yuliyao.growthdemo.factory;

/**
 * @author YuLiyao
 * @date 2019/1/28
 */
public class DefaultFacotry extends AbstractFactory {
    @Override
    Car getCar() {
        return new Audi();
    }


}
