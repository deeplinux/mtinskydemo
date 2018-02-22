package com.mtinsky.design.pattern.singleton;

/**
 * 双重检验锁，通过volite和synchronized 保证线程安全
 * 缺点：1, 反序列化会创建一个新的实例
 *       2, 可以通过反射强行调用私有构造器
 */
public class Singleton3 {
    private static volatile Singleton3 instance = null;
    private Singleton3(){};
    public static Singleton3 getInstance() {
        if(instance==null) {
            synchronized (Singleton3.class) {
                if(instance==null) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}
