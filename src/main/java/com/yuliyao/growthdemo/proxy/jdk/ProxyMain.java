package com.yuliyao.growthdemo.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * @author yuliyao
 * @date 2018/12/30
 */
public class ProxyMain {

    public static void main(String[] args) {
        Zhangsan zhangsan = new Zhangsan();
        MatchMaker matchMaker = new MatchMaker(zhangsan);
        IPerson zhangsanProxy = (IPerson) Proxy.newProxyInstance(zhangsan.getClass().getClassLoader(), zhangsan.getClass()
                .getInterfaces(), matchMaker);
        zhangsanProxy.findLove();

    }
}
