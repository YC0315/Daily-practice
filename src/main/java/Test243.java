import java.util.AbstractCollection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author: yangchao
 * @createTime: 2022-09-05  16:30
 * @description: Runnable接口的run方法是没有返回值的。当我们需要子线程运行结束后提供一个返回值时，就需要用到Callable接口。
 * Callable的返回值支持泛型，但因为它的返回值是异步返回的，因此无法直接在主线程中获取返回值，而是配合Future接口或FutureTask类来获取返回值。
 */
public class Test243 {
    /*
     1、定义一个线程任务类实现Callable接口，声明线程执行的结果类型。
     2、重写线程任务类的call()方法，这个方法可以直接返回执行的结果。
     3、创建一个Callable的线程任务对象。
     4、把Callable的线程任务对象包装成一个未来任务对象。
     5、把未来任务对象包装成线程对象。
     6、调用线程start()方法，启动线程。
     7、获取线程执行结果。
     **/
    public static void main(String[] args) {
        // 1创建一个Callable的线程任务对象。
        MyCallable myCallable = new MyCallable();

        // 2把Callable的线程任务对象包装成一个未来任务对象
        FutureTask<String> futureTask = new FutureTask<>(myCallable);

        // 3把未来任务对象包装成线程对象
        Thread thread = new Thread(futureTask);

        // 4启动线程
        thread.start();

        // 5获取返回值, 如果线程还没运行结束，则get()会等待，直到线程结束返回结果
        try {
            String s = futureTask.get();
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// 定义一个类实现Callable接口，并指明返回值类型
class MyCallable implements Callable<String> {

    // 重写call方法
    @Override
    public String call() throws Exception {
       //  System.out.println("abc");  // 也可以直接输出
        return "子线程执行任务，线程名称为：" + Thread.currentThread().getName();
    }
}
