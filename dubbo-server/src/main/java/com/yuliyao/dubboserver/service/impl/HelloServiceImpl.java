package com.yuliyao.dubboserver.service.impl;

import com.yuliyao.dubbo.service.IHelloService;

/**
 * @author yuliyao
 * @date 2019/7/27
 */
public class HelloServiceImpl implements IHelloService {

    @Override
    public String sayHello(String name) {
        System.out.println("hello:" + name);
        return "hello:" + name;
    }
}
