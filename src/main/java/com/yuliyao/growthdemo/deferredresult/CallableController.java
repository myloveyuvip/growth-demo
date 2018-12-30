package com.yuliyao.growthdemo.deferredresult;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

/**
 * @author yuliyao
 * @date 2018/12/30
 * callable：异步开启一个任务线程，tomcat接收线程执行完成后先行释放该线程
 */
@RestController
public class CallableController {

    @RequestMapping("/getCallableResult")
    public Callable<String> getCallableResult() {
        System.out.println("main thread begin! Thread name:"+Thread.currentThread().getName());
        //交由callable任务线程执行耗时业务操作
        Callable<String> result = () -> {
            System.out.println("callable thread begin! Thread Name:"+Thread.currentThread().getName());
            Thread.sleep(3000L);
            System.out.println("callable thread begin! Thread name:"+Thread.currentThread().getName());
            return "this is callable result!";
        };
        System.out.println("main thread end! Thread name:"+Thread.currentThread().getName());
        return result;
    }
}
