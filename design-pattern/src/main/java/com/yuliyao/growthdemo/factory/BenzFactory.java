package com.yuliyao.growthdemo.factory;

import com.yuliyao.growthdemo.factory.Benz;
import com.yuliyao.growthdemo.factory.Car;
import com.yuliyao.growthdemo.factory.FactoryMethod;

/**
 * @author YuLiyao
 * @date 2019/1/28
 */
public class BenzFactory implements FactoryMethod {

    @Override
    public Car getCar() {
        return new Benz();
    }
}
