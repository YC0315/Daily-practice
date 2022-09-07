/**
 * @author: yangchao
 * @createTime: 2022-09-06  08:34
 * @description: 多线程打印ABC：使用Runnable接口
 */
public class Test247 {
    // 定义同步标志和锁对象
    private volatile char flag = 'A';
    private static final Object lock = new Object();

    Runnable a = () -> {
        while(true){
            synchronized (lock){
                if(flag == 'A'){
                    System.out.println(Thread.currentThread().getName() + ":" + "A");
                    flag = 'B';
                    lock.notifyAll(); // 唤醒其他线程
                }else{
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    };

    Runnable b = () -> {
        while(true){
            synchronized (lock){
                if(flag == 'B'){
                    System.out.println(Thread.currentThread().getName() + ":" + "B");
                    flag = 'C';
                    lock.notifyAll(); // 唤醒其他线程
                }else{
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    };

    Runnable c = () -> {
        while(true){
            synchronized (lock){
                if(flag == 'C'){
                    System.out.println(Thread.currentThread().getName() + ":" + "C");
                    flag = 'A';
                    lock.notifyAll(); // 唤醒其他线程
                }else{
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    };

    public void runTest(){
        Thread ta = new Thread(a);
        Thread tb = new Thread(b);
        Thread tc = new Thread(c);
        ta.start();
        tb.start();
        tc.start();
    }

    public static void main(String[] args) {
        Test247 test247 = new Test247();
        test247.runTest();
    }
}
