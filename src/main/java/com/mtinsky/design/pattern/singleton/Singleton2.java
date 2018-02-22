package com.mtinsky.design.pattern.singleton;

/**
 * 懒汉模式，线程安全，
 * 缺点：1, 反序列化会创建一个新的实例
 *       2, 可以通过反射强行调用私有构造器
 *       3, 性能相对不高
 */
public class Singleton2 {
    private static Singleton2 instance = null;
    private Singleton2(){};
    public static synchronized Singleton2 getInstance() {
        if(null == instance) {
            instance = new Singleton2();
        }
        return instance;
    }
}
