package com.yuliyao.growthdemo.proxy.jdk;

/**
 * @author yuliyao
 * @date 2018/12/30
 * 类型的强制转换，只能在子类和父类之间，所以JDK动态代理只能代理有接口的类
 */
public class ObjectTransTest {


    public static void main(String[] args) {
        Animal animalCat = new Cat();
        Animal animalDog = new Dog();
        //把Animal转成子类，需要强转
        Cat cat = (Cat) animalCat;
        cat.eat();
        Dog dog = (Dog) animalDog;
        dog.eat();
        //把子类转成父类，不需要强转
        Cat cat1 = new Cat();
        Animal animal = cat1;
        animal.eat();
        //把Dog转成Cat
        Cat cat2 = (Cat) animalDog;
        cat2.eat();
    }
}
