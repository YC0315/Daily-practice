import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author: yangchao
 * @createTime: 2022-07-13  20:13
 * @description: 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
 *               括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
 */
public class Test54 {
    public boolean isValid (String s) {
        // 维护一个辅助栈
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if(aChar == '('){
                stack.push(')');
            }else if(aChar == '{'){
                stack.push('}');
            }else if(aChar == '['){
                stack.push(']');
            }else{
                // 如果栈空（说明当前元素是单独出现的右括号）或者栈顶元素不为匹配元素则括号序列不合法
                if(stack.isEmpty() || aChar != stack.pop()){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
