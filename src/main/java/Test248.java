/**
 * @author: yangchao
 * @createTime: 2022-09-06  08:43
 * @description: 多线程交替打印ABC
 */
public class Test248 {
    private static int num = 1;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
           while(num <= 100){
               synchronized (lock){
                   if(num % 2 == 0){
                       try {
                           lock.wait();
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }else{
                       System.out.println(Thread.currentThread().getName() + ":" + "ABC");
                       num++;
                       lock.notify();
                   }
               }
           }
        },"线程1").start();
        new Thread(() -> {
            while(num <= 100){
                synchronized (lock){
                    if(num % 2 != 0){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else{
                        System.out.println(Thread.currentThread().getName() + ":" + "ABC");
                        num++;
                        lock.notify();
                    }
                }
            }
        },"线程2").start();
    }

}
