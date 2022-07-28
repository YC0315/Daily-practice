import org.junit.Test;

import javax.sound.midi.Soundbank;

/**
 * @author: yangchao
 * @createTime: 2022-07-21  11:12
 * @description: 多线程交替打印数字的方式
 */

public class Test77 {
    // 1、使用synchronzied/wait()/notify()机制
    public static void main(String[] args) throws InterruptedException {
        // 创建两个执行任务的线程
        Task task = new Task();
        Thread thread1 = new Thread(task, "线程1: ");
        Thread thread2 = new Thread(task, "线程2: ");
        thread1.start();
        Thread.sleep(1000);
        thread2.start();
    }

    // 使用valatile标志位实现
    /*
    使用@Test注解的注意事项!!
    1.注意类的修饰符要为public
    2.方法修饰符不可含有static
    3.测试方法无返回值
    */
    static volatile boolean flag = true;
    static volatile int num = 1;

    /*public static void main(String[] args) throws InterruptedException {
        printOdd odd = new printOdd();
        printEven even = new printEven();
        Thread thread1 = new Thread(odd,"奇数：");
        Thread thread2 = new Thread(even,"偶数：");
        thread1.start();
        Thread.sleep(1000);
        thread2.start();
    }*/
    // 奇数
    static class printOdd implements Runnable{
        @Override
        public void run() {
            while(num <= 10){
                if(flag){
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
    // 偶数
    static class printEven implements Runnable{
        @Override
        public void run() {
            while(num <= 10){
                if(!flag){
                    System.out.println(Thread.currentThread().getName() + ":" + num++);
                    // 下面这句代码在if里面，只有当输出数字之后再变换状态
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

// 使用synchronzied/wait()/notify()机制
class Task implements Runnable {
    int i = 1;
    @Override
    public void run() {
        while (true) {
            synchronized (this) {  // 锁住同一对象
                if (i <= 10) {
                    System.out.println(Thread.currentThread().getName() + i);
                    i++;
                } else {
                    break;
                }
                // 唤醒其他线程
                notify();
                try {
                    // 阻塞当前线程
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
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



