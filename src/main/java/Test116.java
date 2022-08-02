/**
 * @author: yangchao
 * @createTime: 2022-08-02  08:15
 * @description: 单例模式
 */
public class Test116 {
    // 饿汉式-提前加载,线程安全
    private static Test116 instance = new Test116();

    private Test116() {
    }
    public static Test116 getInstance(){
        return instance;
    }
}

// 懒汉式，延迟创建，线程不安全
class Singleton13{
    private static Singleton13 intance = null;

    private Singleton13() {
    }
    public static Singleton13 getInstance(){
        if(intance == null){
            intance = new Singleton13();
        }
        return intance;
    }
}
// 懒汉式-改进，线程安全
class Singleton14{
    private static volatile Singleton14 intance = null;
    private Singleton14() {
    }
    public static Singleton14 getInstance(){
        if(intance == null){
            synchronized (Singleton14.class){
                if(intance == null){
                    intance = new Singleton14();
                }
            }
        }
        return intance;
    }
}
