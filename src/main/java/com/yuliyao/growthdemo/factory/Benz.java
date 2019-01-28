package com.yuliyao.growthdemo.factory;

/**
 * @author YuLiyao
 * @date 2019/1/28
 */
public class Benz implements Car{


    @Override
    public void drive() {
        System.out.println("我是奔驰，坐我！");
    }
}
