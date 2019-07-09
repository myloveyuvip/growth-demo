package com.yuliyao.growthdemo.zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author yuliyao
 * @date 2019/7/9
 */
public class ZookeeperClientDemo implements Watcher {

    private ZooKeeper zooKeeper;

    private CountDownLatch countDownLatch = new CountDownLatch(1);

    {
        try {
            zooKeeper = new ZooKeeper("127.0.0.1:2181", 3000, new ZookeeperClientDemo());
            countDownLatch.await();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void create(String path, String data) {
        try {
            System.out.println(zooKeeper.getState());
            zooKeeper.create(path, data.getBytes(), null, null);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
            countDownLatch.countDown();
        }

    }

    public static void main(String[] args) {
        try {
            ZooKeeper zooKeeper = new ZooKeeper("localhost:2181", 3000, new ZookeeperClientDemo());
            System.out.println(zooKeeper.getState());
            zooKeeper.create("/zk-test", "foo".getBytes(), null, CreateMode.EPHEMERAL);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }
}
