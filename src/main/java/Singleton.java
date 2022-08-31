/**
 * @author: yangchao
 * @createTime: 2022-07-17  19:06
 * @description: 单例模式
 */
// 单例模-饿汉式（线程安全）
public class Singleton {
    // 提前创建好实例,定义成static这样初始化时只会创建一个实例
    private static Singleton instance = new Singleton();

    private Singleton() {
    }  // 构造方法私有化，外界不能创建对象

    public static Singleton getInstance() {  // 可以使用类名.的方式调用方法
        return instance;
    }
}
// 单例模式-懒汉式（线程不安全）
class Singleton1 {
    // 不会提前创建实例
    private static Singleton1 instance = null;
    private Singleton1() {
    }  // 构造方法私有化，外界不能创建对象
    // 先不创建实例，当第一次被调用时，再创建实例
    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}

// 单例模式-懒汉式（线程安全）
class Singleton2 {
    // 不会提前创建实例
    private static Singleton2 instance = null;
    private Singleton2() {
    }  // 构造方法私有化，外界不能创建对象

    // 先不创建实例，当第一次被调用时，再创建实例,但是这种情况每次多线程调用方法的时候都会阻塞
    public synchronized static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}

// 单例模式-懒汉式（线程安全）
class Singleton3 {
    // 不会提前创建实例
    private volatile static Singleton3 instance = null;
    private Singleton3() {
    }
    /*
        双重检查数相当于是改进了 线程安全的懒汉式。线程安全的懒汉式 的缺点是性能降低了，
        造成的原因是因为即使实例已经实例化，依然每次都会有锁。而现在，我们将锁的位置变了，
        并且多加了一个检查。 也就是，先判断实例是否已经存在，若已经存在了，
        则不会执行判断方法内的有锁方法了。 而如果，还没有实例化的时候，多个线程进去了，也没有事，
        因为里面的方法有锁，只会让一个线程进入最内层方法并实例化实例。如此一来，最多最多，
        也就是第一次实例化的时候，会有线程阻塞的情况，后续便不会再有线程阻塞的问题。
    */
    public static Singleton3 getInstance() {
        if (instance == null) {
            // 锁住的是类对象
            synchronized (Singleton3.class) {
                if (instance == null) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}

// 单例模式-懒汉式（线程安全）
    /*
    首先，当外部类 Singleton 被加载时，静态内部类 SingletonHolder 并没有被加载进内存。
    当调用 getInstance() 方法时，会运行 return SingletonHolder.INSTANCE;
    此时静态内部类 SingletonHolder 才会被加载进内存，初始化 INSTANCE 实例，而且 JVM 会确保 INSTANCE 只被实例化一次。
    */
class Singleton4 {
    private Singleton4() {
    }
    // 使用静态内部类
    private static class SingletonHolder {
        private static final Singleton4 INSTANCE = new Singleton4();
    }
    public static Singleton4 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}


