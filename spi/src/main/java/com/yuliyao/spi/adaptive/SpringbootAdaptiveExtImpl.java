package com.yuliyao.spi.adaptive;


import org.apache.dubbo.common.URL;

/**
 * @author yuliyao
 * @date 2019/8/10
 */
public class SpringbootAdaptiveExtImpl implements AdaptiveExt {

    @Override
    public void sayHello(String msg, URL url) {
        System.out.println("spring boot adaptive!");
    }
}
