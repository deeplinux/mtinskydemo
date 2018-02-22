package com.mtinsky.design.pattern.singleton;


/**
 * 饿汉模式
 * 缺点：1, 反序列化会创建一个新的实例
 *       2, 可以通过反射强行调用私有构造器
 */
public class Singleton1 {
    private static Singleton1 instance = new Singleton1();
    private Singleton1(){};
    public static Singleton1 getInstance() {
        return instance;
    }
}
