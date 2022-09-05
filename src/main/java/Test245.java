/**
 * @author: yangchao
 * @createTime: 2022-09-05  19:04
 * @description: 多线程输出ABC!!!!!
 *
 *  利用synchronized，使用java内置的monitor机制，配合wait和notifyAll，代码如下：
 * （1）利用volatile做线程间资源的同步访问，同时作为线程调度的标志；
 * （2）利用notifyAll来唤醒其他等待当前的monitor资源的线程；
 * （3）wait()和notify()方法必须在synchronized中使用
 */
public class Test245 {
    // 做线程同步的标志
    private volatile char flag = 'A';
    // 对象锁
    private final static Object lock = new Object();

    // Lambda表达式取代匿名内部类，{}是实现了Runnable接口的类(定义一个类实现Runnable接口)
    Runnable a = () ->{
        while(true){
            synchronized (lock){
                if(flag == 'A'){
                    System.out.println(Thread.currentThread().getName() + "A");
                    flag = 'B';
                    lock.notifyAll();  // 输出完以后唤醒其他线程
                }else{
                    try {
                        // wait()的作用是让当前线程进入等待状态，wait()也会让当前线程释放它所持有的锁。
                        // synchronized(lock)这里的锁定了lock，那么wait需用lock.wait()（释放掉lock）
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    };

    Runnable b = () ->{
        while(true){
            synchronized(lock){
                if(flag == 'B'){
                    System.out.println(Thread.currentThread().getName() + "B");
                    flag = 'C';    // 修改同步标志
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
            synchronized(lock){
                if(flag == 'C'){
                    System.out.println(Thread.currentThread().getName() + "C");
                    flag = 'A';
                    lock.notifyAll();
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

    // 创建线程对象并启动
    public void runTest(){
        // 将实现了Runnable接口的对象当做Thread参数传进去，再调用Thread对象的start()
        Thread ta = new Thread(a);
        Thread tb = new Thread(b);
        Thread tc = new Thread(c);
        ta.start();
        tb.start();
        tc.start();
    }
    public static void main(String[] args) {
        Test245 test245 = new Test245();
        test245.runTest();
    }
}
