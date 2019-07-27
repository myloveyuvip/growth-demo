package com.yuliyao.growthdemo.deferredresult;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @author yuliyao
 * @date 2018/12/29
 * 客户端请求服务
 * SpringMVC调用Controller，Controller返回一个DeferredResult对象
 * SpringMVC调用ruquest.startAsync
 * DispatcherServlet以及Filters等从应用服务器线程中结束，但Response仍旧是打开状态，也就是说暂时还不返回给客户端
 * 某些其它线程将结果设置到DeferredResult中，SpringMVC将请求发送给应用服务器继续处理
 * DispatcherServlet再次被调用并且继续处理DeferredResult中的结果，最终将其返回给客户端
 */
@RestController
@Slf4j
public class DeferredResultController {

    private DeferredResult<String> deferredResult = new DeferredResult<>();

    @RequestMapping("/getCommonResult")
    public String getCommonString() {
        return "this is common result!";
    }

    @RequestMapping("/getDeferredResult")
    public DeferredResult testDeferredResult() {
        //此处要重新初始化，否则deferredResult用过一次会过期
        deferredResult = new DeferredResult<>();
        log.info("main thread begin..." + Thread.currentThread().getName());
        log.info(("main thread end!" + Thread.currentThread().getName()));
        return deferredResult;
    }

    @RequestMapping("/setResult")
    public String setResult(String result) {
        log.info("给deferredResult设值，线程：" + Thread.currentThread().getName());
        deferredResult.setResult(result);
        return "设置成功，值为：" + result;
    }

}
