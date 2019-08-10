package com.yuliyao.spi.java;

import org.apache.dubbo.common.extension.SPI;

/**
 * @author yuliyao
 * @date 2019/8/10
 */
//SPI仅dubbo使用需要
@SPI
public interface Robot {
    void sayHello();
}
