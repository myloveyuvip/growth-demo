package com.yuliyao.spi.adaptive;

import org.apache.dubbo.common.URL;

/**
 * @author yuliyao
 * @date 2019/8/10
 */
public class RaceCarMaker implements CarMaker {

    private WheelMaker wheelMaker;

    public void setWheelMaker(WheelMaker wheelMaker) {
        this.wheelMaker = wheelMaker;
    }


    @Override
    public Car makeCar(URL url) {

        Wheel wheel = wheelMaker.makeWheel(url);
        return new Car(wheel);
    }

}
