package com.yuliyao.growthdemo;

import org.junit.Test;

/**
 * @author YuLiyao
 * @date 2019/8/16
 */
public class EnumTest {


    @Test
    public void testEnum() {
        ValueOfEnums test = ValueOfEnums.valueOf("TEST");
        System.out.println(test);
    }
}
