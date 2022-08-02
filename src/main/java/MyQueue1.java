import java.util.ArrayList;
import java.util.List;

/**
 * @author: yangchao
 * @createTime: 2022-07-31  22:25
 * @description: 数组实现队列，先进先出，维护两个数组，确保main数组的先进先出
 */
public class MyQueue1 {
    List<Integer> queue = null;
    public MyQueue1(){
        queue = new ArrayList<>();
    }
    public void push(int x){
        queue.add(x);
    }
    public int pop(){
        return queue.remove(0);
    }
    public int peek(){
        Integer integer = queue.remove(0);
        queue.add(0, integer);
        return integer;
    }
    public boolean empty() {
        return queue.isEmpty();
    }

}
