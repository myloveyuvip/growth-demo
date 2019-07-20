package com.yuliyao.growthdemo.zookeeper;

import com.alibaba.fastjson.JSON;
import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

import java.util.List;

/**
 * @author yuliyao
 * @date 2019/7/20
 */
public class ZkClientDemo {


    private ZkClient zkClient = new ZkClient("localhost:2181", 3000);

    /**
     * 创建节点
     * @param path
     * @param data
     * @param mode
     */
    public void create(String path,String data, CreateMode mode) {
        String zkClient = this.zkClient.create(path, data.getBytes(), mode);
        System.out.println("创建成功！创建路径为："+zkClient);
    }

    /**
     * 获取节点
     * @param path
     * @return
     */
    public Object get(String path) {
        Stat stat = new Stat();
        Object o = zkClient.readData(path, stat);
        System.out.println("stat信息为：" + JSON.toJSONString(stat));
        System.out.println("节点信息为：" + o);
        return o;
    }

    /**
     * 查询子节点
     * @param path
     * @return
     */
    public List<String> getChildren(String path) {
        List<String> children = zkClient.getChildren(path);
        System.out.println("节节点为："+JSON.toJSONString(children));
        return children;
    }

    /**
     * 修改节点信息
     * @param path
     * @param data
     */
    public void set(String path, String data) {
        zkClient.writeData(path,data);
    }

    /**
     * 删除节点
     * @param path
     */
    public void delete(String path) {
        zkClient.delete(path);
    }

    /**
     * 是否存在
     * @param path
     * @return
     */
    public boolean exist(String path) {
        boolean exists = zkClient.exists(path);
        System.out.println("节点是否存在：" + exists);
        return exists;
    }

    /**
     * 监听
     * @param path
     */
    public void watchPath(String path) {
        zkClient.subscribeDataChanges(path, new IZkDataListener() {
            @Override
            public void handleDataChange(String dataPath, Object data) throws Exception {
                System.out.println(dataPath + "节点变更，数据为：" + data);
            }

            @Override
            public void handleDataDeleted(String dataPath) throws Exception {
                System.out.println(dataPath + "节点删除");
            }
        });
    }

    public void watchChildren(String path) {
        zkClient.subscribeChildChanges(path, new IZkChildListener() {
            @Override
            public void handleChildChange(String parentPath, List<String> currentChilds) throws Exception {
                System.out.println(parentPath + "下的子节点变量，当前子节点为：" + currentChilds);
            }
        });
    }
}
