package com.yuliyao.growthdemo.zookeeper;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yuliyao
 * @date 2019/7/10
 */
public class ZookeeperClientDemoTest {

    @Test
    public void create() {
        ZookeeperClientDemo zookeeperClientDemo = new ZookeeperClientDemo();
        zookeeperClientDemo.create("/zk-test/yuliyao", "haha");
    }
}