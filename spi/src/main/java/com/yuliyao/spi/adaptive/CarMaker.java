package com.yuliyao.spi.adaptive;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.SPI;

/**
 * @author yuliyao
 * @date 2019/8/10
 */
@SPI
public interface CarMaker {


    Car makeCar(URL url);
}
