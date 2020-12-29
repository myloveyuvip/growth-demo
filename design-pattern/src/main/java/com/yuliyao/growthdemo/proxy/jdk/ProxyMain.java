package com.yuliyao.growthdemo.proxy.jdk;

import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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

        //把代理类输出到文件中，查看代理类
        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{IPerson.class});
        try (FileOutputStream fos = new FileOutputStream("E:\\$Proxy0.class")){
            fos.write(bytes);
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
