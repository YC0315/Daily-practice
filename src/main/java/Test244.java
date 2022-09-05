import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author: yangchao
 * @createTime: 2022-09-05  16:48
 * @description: 使用Callable接口，实现多线程共同卖10张票
 */
public class Test244 {
    public static void main(String[] args) throws Exception {
        // 创建Callable对象
        MyCallable1 myCall1 = new MyCallable1();

        // 创建FutureTask对象,多线程一定要创建多个FutureTask对象和多个Thread对象
        FutureTask<String> future1 = new FutureTask<String>(myCall1);
        FutureTask<String> future2 = new FutureTask<String>(myCall1);
        FutureTask<String> future3 = new FutureTask<String>(myCall1);

        Thread thread1 = new Thread(future1);
        Thread thread2 = new Thread(future2);
        Thread thread3 = new Thread(future3);
        thread1.start();
        thread2.start();
        thread3.start();

        // 获取目标线程执行结果通过future对象调用get方法
        System.out.println(future1.get());
        System.out.println(future2.get());
        System.out.println(future3.get());
    }
}

class MyCallable1 implements Callable<String>{
    private static int ticks = 10;
    @Override
    public String call() throws Exception {
        for(int i = 0; i < 10; i++){
            if(ticks > 0){
                System.out.println("票号："+ticks--+"已售卖，售卖窗口为："+Thread.currentThread().getName());
            }
        }
        return "票已卖完"+Thread.currentThread().getName();
    }
}
