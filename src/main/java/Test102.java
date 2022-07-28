import java.util.Stack;

/**
 * @author: yangchao
 * @createTime: 2022-07-28  19:19
 * @description: 有效的括号
 */
public class Test102 {
    /*
        三种情况：左括号多于右括号，右括号多于左括号，左右括号不匹配
     **/
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            }else{
                // 一定要先判断是不是空再去弹出来比较是否匹配，先弹栈的话，就改变了栈的状态的！！
                if(stack.isEmpty() || c != stack.pop()){  // 栈为空表示右括号数大于左括号数，或者左右不匹配
                    return false;
                }
            }
        }
        return stack.isEmpty();  // 左括号多于右括号
    }
}
