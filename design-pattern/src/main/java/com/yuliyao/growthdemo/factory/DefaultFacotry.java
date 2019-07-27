package com.yuliyao.growthdemo.factory;

import com.yuliyao.growthdemo.factory.AbstractFactory;
import com.yuliyao.growthdemo.factory.Audi;

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
