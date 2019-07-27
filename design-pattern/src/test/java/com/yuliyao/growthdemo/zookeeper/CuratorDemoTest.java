package com.yuliyao.growthdemo.zookeeper;

import org.junit.Test;

import java.io.IOException;

/**
 * @author yuliyao
 * @date 2019/7/20
 */
public class CuratorDemoTest {


    private String path = "/curator";

    @Test
    public void testCreate() {
        CuratorDemo demo = new CuratorDemo();
        demo.create(path, "1");
    }

    @Test
    public void testGet() {
        CuratorDemo demo = new CuratorDemo();
        demo.get(path);
    }

    @Test
    public void testCreateEphemeral() throws IOException {
        CuratorDemo demo = new CuratorDemo();
        demo.createEphemeral(path + "/e1", "1");
        System.in.read();
    }

    @Test
    public void createChild() {
        CuratorDemo demo = new CuratorDemo();
        demo.create(path + "/t/e/w/a/a", "2");
    }

    @Test
    public void set() {
        CuratorDemo demo = new CuratorDemo();
        demo.set(path, "22");
    }

    @Test
    public void delete() throws Exception {
        CuratorDemo demo = new CuratorDemo();
        demo.exists(path);
        demo.delete(path);
        demo.exists(path);
    }

    @Test
    public void getChild() {
        CuratorDemo demo = new CuratorDemo();
        demo.getChild(path);
    }

    @Test
    public void testWatch() throws IOException {
        CuratorDemo demo = new CuratorDemo();
        demo.watch(path);
        System.in.read();
    }

    @Test
    public void testNodeCacheWatch() throws IOException {
        CuratorDemo demo = new CuratorDemo();
        demo.nodeWatch(path);
        System.in.read();
    }

    @Test
    public void testLeaderSelect() {
        CuratorDemo demo = new CuratorDemo();
        demo.leaderSelect(path);
    }

    @Test
    public void testTransLock() {
        CuratorDemo demo = new CuratorDemo();
        demo.trandLock();
    }


    @Test
    public void testCountDownLock() throws InterruptedException {
        CuratorDemo demo = new CuratorDemo();
        demo.countDownLock();
    }

    @Test
    public void testDistributedLock() {
        CuratorDemo demo = new CuratorDemo();
        demo.distributedLock(path+"/lock");
    }

    @Test
    public void testAtomicInt() {
        CuratorDemo demo = new CuratorDemo();
        demo.distAtomic(path+"/atomic1");
    }
}
