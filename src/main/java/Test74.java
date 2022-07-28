import static java.lang.Thread.sleep;

/**
 * @author: yangchao
 * @createTime: 2022-07-20  14:56
 * @description: TODO
 */
public class Test74 {
    final static Object obj = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (obj) {
                System.out.println("执行线程1....");
                try {
                    obj.wait(); // 让线程在obj上一直等待下去
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程1其它代码....");
            }
        }).start();
        new Thread(() -> {
            synchronized (obj) {
                System.out.println("执行线程2....");
                try {
                    obj.wait(); // 让线程在obj上一直等待下去
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程2其它代码....");
            }
        }).start();
        // 主线程两秒后执行
        try {
            sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("唤醒 obj 上其它线程");
        synchronized (obj) {
            obj.notify(); // 唤醒obj上一个线程
            // obj.notifyAll(); // 唤醒obj上所有等待线程
        }
    }
}
