package com.yuliyao.growthdemo.zookeeper;

import com.alibaba.fastjson.JSON;
import org.apache.zookeeper.CreateMode;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author yuliyao
 * @date 2019/7/10
 */
public class ZookeeperClientDemoTest {

    private String path = "/zookeeperClient";

    @Test
    public void create() {
        ZookeeperClientDemo zookeeperClientDemo = new ZookeeperClientDemo();
        zookeeperClientDemo.create(path, "haha",CreateMode.PERSISTENT);
    }

    @Test
    public void delete() {
        ZookeeperClientDemo zookeeperClientDemo = new ZookeeperClientDemo();
        zookeeperClientDemo.delete(path,-1);
    }

    @Test
    public void set() {
        ZookeeperClientDemo zookeeperClientDemo = new ZookeeperClientDemo();
        zookeeperClientDemo.setData(path, "修改1", -1);
    }

    @Test
    public void getData() {
        ZookeeperClientDemo zookeeperClientDemo = new ZookeeperClientDemo();
        System.out.println("节点值："+zookeeperClientDemo.getData(path));

    }

    @Test
    public void getChildren() {
        ZookeeperClientDemo demo = new ZookeeperClientDemo();
        List<String> children = demo.getChildren(path);
        System.out.println("子节点："+ JSON.toJSONString(children));
    }

    @Test
    public void createEmphral() {
        ZookeeperClientDemo demo = new ZookeeperClientDemo();
        demo.create(path+"/e","ephemeral",CreateMode.EPHEMERAL);
    }

    @Test
    public void createSeq() {
        ZookeeperClientDemo demo = new ZookeeperClientDemo();
        demo.create(path+"/a","1",CreateMode.PERSISTENT_SEQUENTIAL);
    }
}