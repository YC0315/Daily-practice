import java.util.Stack;

/**
 * @author: yangchao
 * @createTime: 2022-07-12  20:40
 * @description: 两个栈实现一个队列,队列是先入先出的，栈是后入先出的，可以借助栈来中转元素模拟栈；
 *               实现push() pop() isEmpty()方法
 */
public class MyQueue {
    // 提供私有属性！！
    private Stack<Integer> stack1;    private Stack<Integer> stack2;

    public MyQueue() {
        // 初始化MyQueue时创建栈对象
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // 借助另一个栈实现队列的先入先出功能
    public void push(int x) {
        // 借助stack2实现stack1的先入先出，每次入栈时，先把stack1清空，然后放入新元素，再把旧元素加进去
        while(!stack1.isEmpty()){  // 每次放之前先把stack1清空
            stack2.push(stack1.pop());
        }
        stack1.push(x);  // 方法stack1，表示最晚最后入的元素
        while(!stack2.isEmpty()){  // 将stack2中的元素在依次放入stack1,最先入的元素就会最先出
            stack1.push(stack2.pop());
        }
    }

    public int pop() {
        return stack1.pop();
    }

    public int peek() {
        return stack1.peek();
    }

    public boolean empty() {
        return stack1.isEmpty();
    }

}
