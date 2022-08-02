/**
 * @author: yangchao
 * @createTime: 2022-07-31  21:28
 * @description: 单例模式
 */
public class Test110 {

}
// 单例模式
class Singleton10{
    // 饿汉式，提前加载，静态私有属性
    private static Singleton10 instance = new Singleton10();
    // 私有化无参构造方法
    private Singleton10() {
    }
    public static Singleton10 getInstance(){
        return instance;
    }
}
// 懒汉式
class Singleton11{
    private static Singleton11 instance = null;
    private Singleton11() {
    }
    public static Singleton11 getInstance(){
        if(instance == null){
            instance = new Singleton11();
        }
        return instance;
    }
}
// 懒汉式-线程安全
class Singleton12{
    private static volatile Singleton12 instance = null;

    private Singleton12() {
    }
    public static Singleton12 getInstance(){
        if(instance == null){
            synchronized (Singleton12.class){
                if(instance == null){
                    instance = new Singleton12();
                }
            }
        }
        return instance;
    }

}
