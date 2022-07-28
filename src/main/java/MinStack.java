import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author: yangchao
 * @createTime: 2022-07-13  19:46
 * @description: 最小栈：设计一个支持 push ，pop ，top 操作，并能在常数时间O(n)内检索到最小元素的栈。
 *               时间复杂度：O(1),空间复杂度为O(n)
 */
public class MinStack {
    // 我们可以使用一个辅助栈，与元素栈 同步插入与删除!! ，用于存储与每个元素对应的最小值
    private Deque<Integer> mainStack;
    private Deque<Integer> minStack;
    public MinStack() {
        mainStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);// 将整型最大值放在栈底,是一个比较的基准
    }

    public void push(int val) {
        mainStack.push(val);
        minStack.push(Math.min(minStack.peek(), val)); // 不管当前元素是不是最小值，始终要压入一个元素
                                                       // 当前元素不是最小值，就压入上一次的最小值
    }

    public void pop() {
        // 出栈的时候都出，不用管是不是最小值
        mainStack.pop();
        minStack.pop();
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }


    // 或者使用两个二栈模拟
    // 使用两个栈实现一个最小栈,其中一个栈的栈顶元素一直存放入栈的最小值
    private Stack<Integer> mainStack1;
    private Stack<Integer> minStack1;
//    public MinStack() {
//        mainStack1 = new Stack<Integer>();
//        minStack1 = new Stack<Integer>();
//    }

    public void push1(int val) {
        // 主栈入栈
        mainStack.push(val);
        // 如果辅助栈为空，或者当前入栈元素值小于辅助栈栈顶元素值（最小值）
        if(minStack.isEmpty() || minStack.peek() >= val){
            minStack.push(val);
        }
    }

    public void pop1() {
        Integer pop = mainStack.pop();
        // 主栈元素出栈，加入出栈元素等于辅助栈栈顶元素，辅助栈栈顶元素也出栈（包装类比较大小使用equals()）
        if(pop.equals(minStack.peek())){
            minStack.pop();
        }
    }

    public int top1() {
        return mainStack.peek();

    }

    public int getMin1() {
        return minStack.isEmpty()?0:minStack.peek();
    }
}
