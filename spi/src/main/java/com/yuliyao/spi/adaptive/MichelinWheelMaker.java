package com.yuliyao.spi.adaptive;

import org.apache.dubbo.common.URL;

/**
 * @author yuliyao
 * @date 2019/8/10
 */
public class MichelinWheelMaker implements WheelMaker {

    @Override
    public Wheel makeWheel(URL url) {

        return new Wheel("machelin");
    }

}
