package com.yuliyao.growthdemo.proxy.jdk.custom;

/**
 * @author yuliyao
 * @date 2019/1/1
 */
public class ProxyMain {

    public static void main(String[] args) {
        Zhangsan zhangsan = new Zhangsan();
        MatchMaker matchMaker = new MatchMaker(zhangsan);
        LYProxy.newProxyInstance(zhangsan.getClass().getInterfaces(), matchMaker);
    }
}
