package com.yuliyao.growthdemo.cglib;

/**
 * @author yuliyao
 * @date 2019/1/17
 */
public class ProxyMain {

    public static void main(String[] args) {
        MatchMaker matchMaker = new MatchMaker();
        Zhangsan proxy = (Zhangsan) matchMaker.createObject(new Zhangsan());
        proxy.findLove();

    }
}
