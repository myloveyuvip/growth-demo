package com.yuliyao.growthdemo.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

/**
 * @author yuliyao
 * @date 2019/7/10
 */
public class CuratorDemo {

    public static void main(String[] args) {
        CuratorFramework client = CuratorFrameworkFactory.builder().connectString("localhost:2181").retryPolicy(new
                ExponentialBackoffRetry(1000,3)).
        build();
        client.start();
        String path = "/zk-client/curator";
        try {
//            client.delete().forPath(path);
            client.create().creatingParentContainersIfNeeded().withMode(CreateMode.EPHEMERAL).forPath
                    (path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
