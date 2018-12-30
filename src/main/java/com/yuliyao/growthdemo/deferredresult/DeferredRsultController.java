package com.yuliyao.growthdemo.deferredresult;

import org.apache.logging.log4j.util.Strings;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @author yuliyao
 * @date 2018/12/29
 */
@RestController
public class DeferredRsultController {

    private volatile static String result = null;

    @RequestMapping("/getCommonResult")
    public String getCommonString() {
        return "this is common result!";
    }

    @RequestMapping("/getDeferredResult")
    public DeferredResult testDeferredResult() {
        DeferredResult<String> objectDeferredResult = new DeferredResult<>();
        System.out.println("main thread begin...");
        while (Strings.isEmpty(result)) {
            if (!Strings.isEmpty(result)) {
                objectDeferredResult.setResult(result);
            }
        }
        System.out.println("main thread end!");
        return objectDeferredResult;
    }

    @RequestMapping("/setResult")
    public String setResult(String result1) {
        result = result1;
        return "设置成功，值为：" + result1;
    }

}
