import java.util.Stack;

/**
 * @author: yangchao
 * @createTime: 2022-07-21  19:54
 * @description: 两个栈实现一个队列
 */
public class Test81 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    // 实现stack1的先入先出
    public void push(int node) {
        // 先导出去
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        // 加入最后导入的元素
        stack1.push(node);
        // 再逆序导回来
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    public int pop() {
        return stack1.pop();
    }

    // 或者是正常入栈，出栈的时候操作,时间复杂度为O(1),空间复杂度为O(n)，维护两个栈，每个栈空间最多为n
    public void push1(int node) {
        stack2.push(node);
    }
    // 出栈时把正常栈逆序到另一个栈，从另一个栈出栈
    public int pop1() {
        if(stack1.size()<=0){
            while(!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
        }
        return stack1.pop();
    }
}
