package com.yuliyao.growthdemo.proxy.jdk.custom;

/**
 * @author yuliyao
 * @date 2019/1/1
 */
public class ProxyMain {

    public static void main(String[] args) {
        Zhangsan zhangsan = new Zhangsan();
        MatchMaker matchMaker = new MatchMaker(zhangsan);
        IPerson zsProxy = (IPerson) LYProxy.newProxyInstance(new LYClassLoader(), zhangsan.getClass().getInterfaces(),
                matchMaker);
        zsProxy.findLove();

    }
}
