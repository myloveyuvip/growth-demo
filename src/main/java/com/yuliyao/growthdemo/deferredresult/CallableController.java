package com.yuliyao.growthdemo.deferredresult;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

/**
 * @author yuliyao
 * @date 2018/12/30
 * callable：异步开启一个任务线程，tomcat接收线程执行完成后先行释放该线程。流程如下：
 * 1.客户端请求服务
 * 2.SpringMVC调用Controller，Controller返回一个Callback对象
 * 3.SpringMVC调用ruquest.startAsync并且将Callback提交到TaskExecutor中去执行
 * 4.DispatcherServlet以及Filters等从应用服务器线程中结束，但Response仍旧是打开状态，也就是说暂时还不返回给客户端
 * 5.TaskExecutor调用Callback返回一个结果，SpringMVC将请求发送给应用服务器继续处理
 * 6.DispatcherServlet再次被调用并且继续处理Callback返回的对象，最终将其返回给客户端
 */
@RestController
public class CallableController {

    @RequestMapping("/getCallableResult")
    public Callable<String> getCallableResult() {
        System.out.println("main thread begin! Thread name:" + Thread.currentThread().getName());
        //交由callable任务线程执行耗时业务操作
        Callable<String> result = () -> {
            System.out.println("callable thread begin! Thread Name:" + Thread.currentThread().getName());
            Thread.sleep(3000L);
            System.out.println("callable thread begin! Thread name:" + Thread.currentThread().getName());
            return "this is callable result!";
        };
        System.out.println("main thread end! Thread name:" + Thread.currentThread().getName());
        return result;
    }
}
