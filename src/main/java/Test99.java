import java.util.Stack;

/**
 * @author: yangchao
 * @createTime: 2022-07-27  21:54
 * @description: 有效的括号
 * 输入：s = "()[]{}"
 * 输出：true
 * 三种情况：
 *      1、左右括号不匹配
 *      2、左括号多于右括号
 *      3、右括号多于左括号
 */
public class Test99 {
    public boolean isValid(String s) {
        // 维护一个栈
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if(c == '('){
                stack.add(')');
            }else if(c == '{'){
                stack.add('}');
            }else if(c == '['){
                stack.add(']');
            } else{
                // 一定要先判断是不是空再去弹出来比较是否匹配，先弹栈的话，就改变了栈的状态的！！
                if(stack.isEmpty() || c != stack.pop()){  // 栈为空表示右括号数大于左括号数，或者左右不匹配
                    return false;
                }
            }
        }
        return stack.isEmpty();  // 栈不为空表示左括号数大于右括号数
    }
}
