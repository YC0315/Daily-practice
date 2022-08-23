import java.util.Stack;

/**
 * @author: yangchao
 * @createTime: 2022-08-22  15:35
 * @description: 字符串解码
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * <p>
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 */
public class Test191 {
    // 使用两个辅助栈，
    public String decodeString(String s) {
        int k = 0;  // 存放括号前的数字
        StringBuilder res = new StringBuilder(); // 存放最终的字符串结果
        Stack<Integer> k_stack = new Stack<>();  // 存放每一次的数字
        Stack<StringBuilder> pre_stack = new Stack<>(); // 存放数字前的字母

        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (Character.isLetter(c)) {
                res.append(c);
            } else if (Character.isDigit(c)) {
                // 如果是数字的话，有可能是多位数字
                k = k * 10 + c - '0';
            }else if(c == '['){
                k_stack.push(k);
                pre_stack.push(res);
                k = 0;
                res = new StringBuilder();
            }else if(c == ']'){
                int curr_k = k_stack.pop(); // 取出重复的字母的次数
                StringBuilder temp = pre_stack.pop(); // 将其拼接到重复字符的前面
                // 拼接k次重复的res
                for (int i = 0; i < curr_k; i++) {
                    temp.append(res);
                }
                res = temp;
            }
        }
        return res.toString();
    }
}
