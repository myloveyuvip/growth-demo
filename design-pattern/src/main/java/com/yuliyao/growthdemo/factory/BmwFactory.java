package com.yuliyao.growthdemo.factory;

import com.yuliyao.growthdemo.factory.Bmw;
import com.yuliyao.growthdemo.factory.Car;
import com.yuliyao.growthdemo.factory.FactoryMethod;

/**
 * @author YuLiyao
 * @date 2019/1/28
 */
public class BmwFactory implements FactoryMethod {

    @Override
    public Car getCar() {
        return new Bmw();
    }
}
