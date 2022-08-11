import java.util.Stack;

/**
 * @author: yangchao
 * @createTime: 2022-08-11  18:37
 * @description: 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 */
public class Test142 {
    public static void main(String[] args) {
        String s = "[";
        boolean valid = isValid(s);
        System.out.println(valid);
    }
    // 三种情况：左括号多于右括号，右括号多于左括号，左右括号不匹配
    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        // 维护一个栈
        Stack<Character>  stack = new Stack<>();
        for (char aChar : chars) {
            if(aChar == '('){
                stack.add(')');
            }else if(aChar == '['){
                stack.add(']');
            }else if(aChar == '{'){
                stack.add('}');
            }else{
                // 右括号是否多于左括号，或者左右括号不匹配
                if( stack.isEmpty() || aChar !=  stack.pop()){
                    return false;
                }
            }
        }
        return  stack.isEmpty(); // 左括号是否多于右括号
    }
}
