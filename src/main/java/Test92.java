/**
 * @author: yangchao
 * @createTime: 2022-07-25  14:22
 * @description: 使用volatile实现多线程交替打印数字
 */
public class Test92 {
    static volatile boolean flag = true;
    static volatile int num = 1;

    public static void main(String[] args) throws InterruptedException {
        mutilThreadPrintNumOdd m1 = new mutilThreadPrintNumOdd();
        mutilThreadPrintNumEven m2 = new mutilThreadPrintNumEven();
        Thread thread1 = new Thread(m1,"奇数");
        Thread thread2 = new Thread(m2,"偶数");
        thread1.start();
        Thread.sleep(1000);
        thread2.start();
    }

    public static class mutilThreadPrintNumOdd implements Runnable {
        @Override
        public void run() {
            while (num <= 100) {
                if (flag) {
                    System.out.println(Thread.currentThread().getName() + ":" + num++);
                    flag = false;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class mutilThreadPrintNumEven implements Runnable {
        @Override
        public void run() {
            while (num <= 100) {
                if (!flag) {
                    System.out.println(Thread.currentThread().getName() + ":" + num++);
                    flag = true;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
