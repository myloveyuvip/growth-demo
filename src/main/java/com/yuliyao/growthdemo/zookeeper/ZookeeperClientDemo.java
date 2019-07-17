package com.yuliyao.growthdemo.zookeeper;

import com.alibaba.fastjson.JSON;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author yuliyao
 * @date 2019/7/9
 */
public class ZookeeperClientDemo implements Watcher {

    private ZooKeeper zooKeeper;

    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    /**
     * 获取zk实例
     * @return
     */
    private ZooKeeper getZooKeeper() {
        try {
            zooKeeper = new ZooKeeper("localhost:2181", 3000, new ZookeeperClientDemo());
            System.out.println("zk state:"+zooKeeper.getState());
            countDownLatch.await();
            return zooKeeper;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 创建节点
     * @param path
     * @param data
     * @param createMode
     */
    public void create(String path, String data,CreateMode createMode) {
        try {
            getZooKeeper();
            String result = this.zooKeeper.create(path, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, createMode);
            System.out.println("创建路径：" + result + " 成功！" );
            System.in.read();
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除节点
     * @param path
     * @param version
     */
    public void delete(String path,int version) {
        getZooKeeper();
        try {
            this.getZooKeeper().delete(path, version);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置值
     * @param path
     * @param data
     * @param version
     */
    public void setData(String path,String data, int version) {
        getZooKeeper();
        try {
            this.getZooKeeper().setData(path, data.getBytes(), version);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取节点值
     * @param path
     */
    public String  getData(String path) {
        getZooKeeper();
        Stat stat = new Stat();
        try {
            byte[] data = this.getZooKeeper().getData(path, true, stat);
            System.out.println("stat:" + JSON.toJSONString(stat));
            System.in.read();
            return new String(data);
        } catch (KeeperException e) {

            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取子节点
     * @param path
     * @return
     */
    public List<String> getChildren(String path) {
        getZooKeeper();
        try {
            List<String> children = this.zooKeeper.getChildren(path, true);
            System.in.read();
            return children;
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("接收到事件："+JSON.toJSONString(watchedEvent));
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
            countDownLatch.countDown();
        }

    }

    public static void main(String[] args) {
        try {
            ZooKeeper zooKeeper = new ZooKeeper("localhost:2181", 3000, new ZookeeperClientDemo());
            countDownLatch.await();
            System.out.println(zooKeeper.getState());
            zooKeeper.create("/zk-test", "foo".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }
}
