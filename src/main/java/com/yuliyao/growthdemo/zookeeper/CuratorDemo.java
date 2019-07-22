package com.yuliyao.growthdemo.zookeeper;

import com.alibaba.fastjson.JSON;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.atomic.AtomicValue;
import org.apache.curator.framework.recipes.atomic.DistributedAtomicInteger;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.framework.recipes.leader.LeaderSelector;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListener;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.data.Stat;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author yuliyao
 * @date 2019/7/10
 */
public class CuratorDemo {


    private CuratorFramework client;

    {
        client = CuratorFrameworkFactory.builder().connectString("localhost:2181").retryPolicy(new
                ExponentialBackoffRetry(1000,3)).build();
        client.start();
    }

    /**
     * 创建
     * @param path
     * @param data
     * @return
     */
    public String create(String path, String data) {
        try {
            String s = client.create().creatingParentsIfNeeded().forPath(path, data.getBytes());
            System.out.println("创建路径成功：" + path);
            return s;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 创建临时节点
     * @param path
     * @param data
     * @return
     */
    public String createEphemeral(String path, String data) {
        try {
            String s = client.create().withMode(CreateMode.EPHEMERAL).forPath(path, data.getBytes());
            System.out.println("创建临时节点成功！" + path);
            return s;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String get(String path) {
        try {
            String s = client.getData().forPath(path).toString();
            System.out.println(path + "路径数据为：" + s);
            return s;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getChild(String path) {
        List<String> strings = null;
        try {
            strings = client.getChildren().forPath(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(path + "下的节节点为：" + JSON.toJSONString(strings));
        return strings;
    }

    public void set(String path, String data) {
        try {
            client.setData().forPath(path, data.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String path) throws Exception {
        client.delete().deletingChildrenIfNeeded().forPath(path);
    }

    public void exists(String path) {
        Stat stat = null;
        try {
            stat = client.checkExists().forPath(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(path + "节点状态为：" + JSON.toJSONString(stat));
    }

    public void watch(String path) {
        try {
            client.getData().usingWatcher(new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    System.out.println(event.getPath()+"变更，事件类型为："+JSON.toJSONString(event.getType()));
                }
            }).forPath(path);
            client.getChildren().usingWatcher(new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    System.out.println(event.getPath()+"子节点变更，类型为："+JSON.toJSONString(event.getType()));
                }
            }).forPath(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用nodeCache进行监听
     * @param path
     */
    public void nodeWatch(String path) {
        NodeCache nodeCache = new NodeCache(client, path);
        try {
            nodeCache.start();
            nodeCache.getListenable().addListener(new NodeCacheListener() {
                @Override
                public void nodeChanged() throws Exception {
                    System.out.println(path+"节点变更，新节点值为："+nodeCache.getCurrentData());
                }
            });
            PathChildrenCache childrenCache = new PathChildrenCache(client, path, true);
            childrenCache.start();
            childrenCache.getListenable().addListener(new PathChildrenCacheListener() {
                @Override
                public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) throws Exception {
                    System.out.println(path+"子节点变更，新子节点值为："+JSON.toJSONString(childrenCache.getCurrentData()));
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * leader选举
     */
    public void leaderSelect(String path) {
        LeaderSelector leaderSelector = new LeaderSelector(client, path + "/leaderSelect", new LeaderSelectorListener() {
            @Override
            public void takeLeadership(CuratorFramework client) throws Exception {
                System.out.println("当选为leader");
                Thread.sleep(3000);
                System.out.println("操作完成，释放leader权利！");
            }

            @Override
            public void stateChanged(CuratorFramework client, ConnectionState newState) {

            }
        });

        leaderSelector.autoRequeue();
        leaderSelector.start();
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private int count = 0;

    public void trandLock() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(count);
                count++;
            }).start();
        }
    }

    public void countDownLock() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(count);
                    count++;
                }
            }).start();

        }
        countDownLatch.countDown();
    }

    public void distributedLock(String path) {
        InterProcessMutex lock = new InterProcessMutex(client, path);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < 30; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("====="+count);
                        countDownLatch.await();
                        lock.acquire();
                        if (lock.isAcquiredInThisProcess()) {
                            System.out.println(count);
                            count++;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }finally {
                        try {
                            lock.release();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
        countDownLatch.countDown();
    }

    public void distAtomic(String path) {
        DistributedAtomicInteger atomicInteger = new DistributedAtomicInteger(client, path, new ExponentialBackoffRetry
                (1000, 3));
        for (int i = 0; i < 30; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        AtomicValue<Integer> add = atomicInteger.add(8);
                        System.out.println(add.succeeded()+"执行的值为："+add.postValue());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        }
    }



}
