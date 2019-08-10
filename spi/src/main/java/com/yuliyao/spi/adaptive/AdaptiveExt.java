package com.yuliyao.spi.adaptive;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

/**
 * @author yuliyao
 * @date 2019/8/10
 */
@SPI
public interface AdaptiveExt {

    /**
     * @Adaptive注解没有指定value时，param的值默认为类小写，以.分隔。此类为『adaptive.ext』
     * @param msg
     * @param url
     */
    @Adaptive(value = "adaptiveName")
    public void sayHello(String msg, URL url);


}
