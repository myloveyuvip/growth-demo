package com.yuliyao.growthdemo.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.junit.Test;

import java.io.IOException;

/**
 * @author yuliyao
 * @date 2019/7/20
 */
public class ZkClientDemoTest {

    private String path = "/zkClient";

    @Test
    public void testCreate() {

        ZkClientDemo zkClientDemo = new ZkClientDemo();
        zkClientDemo.create(path, "haha", CreateMode.PERSISTENT);

    }

    @Test
    public void testCreateEmerphal() throws IOException {
        ZkClientDemo zkClientDemo = new ZkClientDemo();
        zkClientDemo.create(path + "/e", "1", CreateMode.EPHEMERAL);
        System.in.read();
    }

    @Test
    public void testCreateSeq() {
        ZkClientDemo demo = new ZkClientDemo();
        demo.create(path + "/", "1", CreateMode.PERSISTENT_SEQUENTIAL);
    }

    @Test
    public void testGet() {
        ZkClientDemo demo = new ZkClientDemo();
        demo.get(path);
    }

    @Test
    public void testSet() {
        ZkClientDemo demo = new ZkClientDemo();
        demo.set(path, "3");
        demo.get(path);
    }

    @Test
    public void testDelete() {
        ZkClientDemo demo = new ZkClientDemo();
        String path = this.path + "/0000000002";
        demo.exist(path);
        demo.delete(path);
        demo.exist(path);
    }

    @Test
    public void testGetChildren() {
        ZkClientDemo demo = new ZkClientDemo();
        demo.getChildren(path);
    }

    @Test
    public void watch() throws IOException {
        ZkClientDemo demo = new ZkClientDemo();
        demo.watchPath(path);
        demo.watchChildren(path);
        System.in.read();
    }

}
