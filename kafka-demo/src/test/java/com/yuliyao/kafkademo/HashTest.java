package com.yuliyao.kafkademo;

import org.junit.Test;

/**
 * @author YuLiyao
 * @date 2019/11/14
 */

public class HashTest {

    @Test
    public void testHashCode() {

        String str = "consumerGroup2";
        System.out.println(str.hashCode()%50);

    }


}
