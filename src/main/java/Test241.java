/**
 * @author: yangchao
 * @createTime: 2022-09-05  15:18
 * @description: 多线程的实现方式1：定义一个类继承Thread类重写run方法
 */
public class Test241 {
    /*
     * 首先定义一个类来继承 Thread 类，重写 run 方法。
     * 然后创建这个子类对象，并调用 start 方法启动线程。
     **/
    public static void main(String[] args) {
        // 单线程执行的话就创建一个Thread对象
        // 创建子类对象
        //MyThread myThread = new MyThread();
        //myThread.start();

        // 多线程就创建多个Thread对象
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        MyThread myThread3 = new MyThread();
        myThread1.start();
        myThread2.start();
        myThread3.start();
    }
}

class MyThread extends Thread {
    // 这块要设置成static
    private static int ticks = 10;

    // 重写run方法
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (ticks > 0) {
                System.out.println("票号：" + ticks-- + "已售卖，售卖窗口为：" + Thread.currentThread().getName());
            }
        }
    }
}
