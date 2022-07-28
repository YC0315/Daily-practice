import java.util.Stack;

/**
 * 有效的括号：
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 */
public class Test14 {
    // 第一种解法，使用栈
    public boolean isValid(String s) {
        // 维护一个栈，存放字符
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
                // 假如c不等于弹出的字符或者弹出和压入数量不同，也就是左括号和右括号的个数不一致！
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        // 左括号和右括号的数量不一致！
        // 字符串中的左括号多
        return stack.isEmpty();
    }

    // 第二种方法，使用替换
    public static boolean isValid1(String s) {
        char[] chars = s.toCharArray();
        // 如果字符数组为奇数则直接返回false
        if (chars.length % 2 != 0) {
            return false;
        }
        int time = chars.length / 2;
        for (int i = 0; i < time; ++i) {
            // 成对的替换掉括号！
            s = s.replace("()", ""); // replace函数的返回值是一个字符串
            s = s.replace("[]", "");
            s = s.replace("{}", "");
        }
        return s.length() == 0;
    }

    public static void main(String[] args) {
        String s = "{()[]}";
        boolean valid1 = isValid1(s);
        System.out.println(valid1);
    }
}
