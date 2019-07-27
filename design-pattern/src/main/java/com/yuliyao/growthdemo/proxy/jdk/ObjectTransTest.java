package com.yuliyao.growthdemo.proxy.jdk;

import com.yuliyao.growthdemo.proxy.jdk.Dog;

/**
 * @author yuliyao
 * @date 2018/12/30
 * 类型的强制转换，只能在子类和父类之间，所以JDK动态代理只能代理有接口的类
 */
public class ObjectTransTest {


    public static void main(String[] args) {
        com.yuliyao.growthdemo.proxy.jdk.Animal animalCat = new com.yuliyao.growthdemo.proxy.jdk.Cat();
        com.yuliyao.growthdemo.proxy.jdk.Animal animalDog = new Dog();
        //把Animal转成子类，需要强转
        com.yuliyao.growthdemo.proxy.jdk.Cat cat = (com.yuliyao.growthdemo.proxy.jdk.Cat) animalCat;
        cat.eat();
        Dog dog = (Dog) animalDog;
        dog.eat();
        //把子类转成父类，不需要强转
        com.yuliyao.growthdemo.proxy.jdk.Cat cat1 = new com.yuliyao.growthdemo.proxy.jdk.Cat();
        com.yuliyao.growthdemo.proxy.jdk.Animal animal = cat1;
        animal.eat();
        //把Dog转成Cat
        com.yuliyao.growthdemo.proxy.jdk.Cat cat2 = (com.yuliyao.growthdemo.proxy.jdk.Cat) animalDog;
        cat2.eat();
    }
}
