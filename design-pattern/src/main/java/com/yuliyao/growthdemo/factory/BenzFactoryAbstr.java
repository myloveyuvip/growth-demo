package com.yuliyao.growthdemo.factory;

import com.yuliyao.growthdemo.factory.AbstractFactory;
import com.yuliyao.growthdemo.factory.Benz;
import com.yuliyao.growthdemo.factory.Car;

/**
 * @author YuLiyao
 * @date 2019/1/28
 */
public class BenzFactoryAbstr extends AbstractFactory {

    @Override
    Car getCar() {
        return new Benz();
    }
}
