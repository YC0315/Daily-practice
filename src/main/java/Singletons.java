/**
 * @author: yangchao
 * @createTime: 2022-08-01  08:12
 * @description: 单例模式
 */
public class Singletons {
    // 懒汉式，延时实例化
    private static Singletons instance = null;
    private Singletons(){
    }
    public static Singletons getInstance(){
        if(instance == null){
            return new Singletons();
        }
        return instance;
    }
}
// 饿汉式，提前实例化
class Singletonss{
    private static Singletonss instance = new Singletonss();

    private Singletonss() {
    }
    public Singletonss getInstance(){
        return instance;
    }
}

// 懒汉式线程不安全以及效率低所作的改进
class Singletonsss{
    private static volatile Singletonsss instance = null;

    private Singletonsss() {
    }
    public static Singletonsss getInstance(){
        if(instance == null){
            synchronized (Singletonsss.class){
                if(instance==null){
                    return new Singletonsss();
                }
            }
        }
        return instance;
    }
}
