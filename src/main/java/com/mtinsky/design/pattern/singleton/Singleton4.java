package com.mtinsky.design.pattern.singleton;

/**
 * 静态内部类
 * 缺点：1, 反序列化会创建一个新的实例
 *       2, 可以通过反射强行调用私有构造器
 */
public class Singleton4 {
    private static class SingletonHolder {
        public static Singleton4 instance = new Singleton4();
    }
    private Singleton4(){};
    private static Singleton4 getInstance(){
        return SingletonHolder.instance;
    }
}
