package com.yuliyao.growthdemo.singleton;

/**
 * @author yuliyao
 * @date 2019/1/26
 * 单例模式的经典写法
 * 单例模式的七种写法 https://cantellow.iteye.com/blog/838473
 */
public final class SingletonDemo {

    /**
     * 使用静态内部类，实现懒汉模式
     */
    public static class LazyHandler{
        private static final SingletonDemo INSTANCE = new SingletonDemo();
    }

    /**
     * 将架构方法设置为私有，不允许别人通过new创建
     */
    private SingletonDemo() {
    }

    /**
     * 定义成final，避免被重写
     */
    public final static SingletonDemo getInstance() {
        return LazyHandler.INSTANCE;
    }
}
