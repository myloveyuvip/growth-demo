package com.yuliyao.math;

import java.math.BigInteger;

/**
 * 二进制相关操作
 * @author YuLiyao
 * @date 2020/3/4
 */
public class Binary {


    /**
     * 十进制转换二进制
     * @param decimalSource
     * @return
     */
    public static String decimalToBinary(int decimalSource) {
        BigInteger bigInteger = new BigInteger(String.valueOf(decimalSource));
        return bigInteger.toString(2);
    }

    /**
     * 十进制转换二进制
     * @param decimalSource
     * @return
     */
    public static String decimalToBinary2                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          (int decimalSource) {
        BigInteger bigInteger = new BigInteger(String.valueOf(decimalSource));
        return bigInteger.toString(2);
    }


    /**
     * 二进制转换十进制
     * @param binarySource
     * @return
     */
    public static String binaryToDecimal(String binarySource) {
        BigInteger bigInteger = new BigInteger(binarySource, 2);
        return bigInteger.toString();
    }

    public static void leftSwift(int demical) {
        System.out.println(demical << 1);
    }


    public static void main(String[] args) {
        int decimalSource = 10;
        String s = decimalToBinary(decimalSource);
        System.out.println(decimalSource + "转换为二进制后为：" + s);

        String binarySource = "10";
        String decimalTarget = binaryToDecimal(binarySource);
        System.out.println(binarySource + "转换十进制后为：" + decimalTarget);

        leftSwift(10);
        System.out.println(10>>2);
        System.out.println(10>>>2);
        //逻辑右移
        System.out.println(-10 >>> 2);
        //算术右移
        System.out.println(-10>>2);

        System.out.println(10 & 3);
        System.out.println(10 | 3);
        System.out.println(10 ^ 3);

    }
}
