/**
 * @author: yangchao
 * @createTime: 2022-09-05  19:33
 * @description: 多线程交替打印ABC：使用继承Thread类的方式
 */
public class Test246 {
    // 对象锁和线程同步的标志
    private static final Object lock = new Object();
    private static int num = 1;

    public static void main(String[] args) {
        // 继承了Thread类的子类对象
        new Thread(() -> {
            synchronized (lock){
                while(num <= 100){
                    if(num % 2 == 0){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else{
                        System.out.println(Thread.currentThread().getName() + ":" + "ABC");
                        num++;
                        // 唤醒其他线程
                        lock.notify();
                    }
                }
            }
        }, "线程1").start();

        new Thread(() -> {
            synchronized (lock){
                while(num <= 100){
                    if(num % 2 != 0){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else{
                        System.out.println(Thread.currentThread().getName() + ":" + "ABC");
                        num++;
                        // 唤醒其他线程
                        lock.notify();
                    }
                }
            }
        }, "线程2").start();
    }
}
