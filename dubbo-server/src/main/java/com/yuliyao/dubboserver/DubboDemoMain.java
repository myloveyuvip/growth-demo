package com.yuliyao.dubboserver;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author yuliyao
 * @date 2019/7/27
 */
public class DubboDemoMain {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        context.start();

        System.in.read();
    }
}
