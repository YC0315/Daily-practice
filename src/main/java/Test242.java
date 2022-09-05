/**
 * @author: yangchao
 * @createTime: 2022-09-05  16:09
 * @description: 多线程的实现方式2:实现 Runnable ，并实现 run 方法
 */
public class Test242 {
    public static void main(String[] args) {
        //创建Runnable 对象,多线程一定要创建多个Runnable对象和多个Thread对象！！！！
        MyRunnable myRunnable1 = new MyRunnable();
        MyRunnable myRunnable2 = new MyRunnable();

        // 将一个 Runnable对象作为Thread的构造参数
        //调用Thread对象的 start 方法，注意不能调用 run 方法

        // 多线程，两个线程一起卖10张票,一起卖只创建一个Runnable对象即可！！！！
        Thread thread = new Thread(myRunnable1);
        thread.start();
        Thread thread2 = new Thread(myRunnable2);
        thread2.start();
    }
}

// 定义一个类实现Runnable类
class MyRunnable implements Runnable {
    private static int ticks = 10;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (ticks > 0) {
                System.out.println("票号：" + ticks-- + "已售卖，售卖窗口为：" + Thread.currentThread().getName());
            }
        }
    }
}
