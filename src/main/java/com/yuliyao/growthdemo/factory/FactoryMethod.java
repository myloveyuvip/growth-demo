package com.yuliyao.growthdemo.factory;

import com.yuliyao.growthdemo.proxy.jdk.Cat;

/**
 * @author YuLiyao
 * @date 2019/1/28
 * 工厂方法：代码扩展性好，但是调用方需要知道对应的工厂方法，增加代码使用的复杂度
 */
public interface FactoryMethod {

    Car getCar();
}