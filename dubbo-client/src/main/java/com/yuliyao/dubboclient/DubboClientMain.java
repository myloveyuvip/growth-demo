package com.yuliyao.dubboclient;

import com.yuliyao.dubbo.service.IHelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yuliyao
 * @date 2019/7/27
 */
public class DubboClientMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        context.start();

        IHelloService helloService = (IHelloService) context.getBean("helloService");
        String larry = helloService.sayHello("larry");
        System.out.println(larry);

    }
}
