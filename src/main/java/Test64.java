import java.security.PrivateKey;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: yangchao
 * @createTime: 2022-07-17  20:53
 * @description: 两线程交替打印AB各5次
 */
public class Test64 {
    // 显示的创建线程，不使用线程池
    static boolean flag = true;
    public static void main(String[] args) {

        Object o = new Object();
        // 定义一个实现Runnable接口的匿名内部类对现象作为Thread类的构造方法的参数
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1准备获取对象控制权");
                synchronized (o) {
                    System.out.println("线程1取得对象控制权");
                    while(!flag){
                        try {
                            System.out.println("线程1执行业务逻辑");
                            System.out.println("线程1调用了notify()方法，唤醒线程2");
                            o.notify();
                            System.out.println("线程1调用了wait()方法，线程1进入等待状态");
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }


                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程2准备获取对象控制权");
                synchronized (o) {
                    System.out.println("线程2取得对象控制权");
                    while(flag){
                        try {
                            System.out.println("线程2执行业务逻辑");
                            System.out.println("线程2调用了notify()方法，唤醒线程1");
                            o.notify();
                            System.out.println("线程2调用了wait()方法，线程2进入等待状态");
                            o.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        });

        thread1.start();
        thread2.start();
    }
}

class printAB {
    private boolean flag = true;

    public void pringA() throws Exception {
        synchronized (this) {
            while (!flag) {   // 假如flag为false则挂起当前线程
                wait();
            }
            System.out.println(Thread.currentThread().getName() + "A");
            flag = false;
            notify(); // 唤醒其他线程
        }
    }

    public void pringB() throws Exception {
        synchronized (this) {
            while (flag) {  // 假如flag为true则挂起当前线程
                wait();
            }
            System.out.println(Thread.currentThread().getName() + "B");
            flag = true;
            notify();
        }
    }
}

// 使用线程池创建线程对象
//输出偶数
class Thread1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println("线程：" + Thread.currentThread().getName() + "，输出偶数" + i);
            }
        }
    }
}

//输出奇数
class Thread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.println("线程：" + Thread.currentThread().getName() + "，输出奇数" + i);
            }
        }
    }
}

class ThreadPools {
    public static void main(String[] args) {
        //创建指定线程数的线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        //执行指定操作的线程，需要提供实现Runnable接口实现类或Callable接口实现类的对象
        //execute()方法适合Runnable
        threadPool.execute(new Thread1());
        threadPool.execute(new Thread2());
        //submit()方法适合Callable
        //关闭线程池
        threadPool.shutdown();
    }
}
