import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author: yangchao
 * @createTime: 2022-08-21  15:31
 * @description: 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * 示例 1：
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 输入：s = "3[a2[c]]x"
 * 输出："accaccaccx"
 */
public class Test189 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String string = decodeString(s);
        System.out.println(string);
    }
    public static String decodeString(String s) {
        // 使用两个辅助栈
        int k = 0; // 存放当前的数字K
        StringBuilder res = new StringBuilder(); // 存放最终的结果
        Stack<Integer> k_stack = new Stack<>();  // 数字栈
        Stack<StringBuilder> pre_stack = new Stack<>();  // 字母栈，用来存放每个数字k之前的字母

        char[] chars = s.toCharArray();
        for (char c : chars) {
            // 指定字符是字母
            if (Character.isLetter(c)) {
                res.append(c);
            } else if (Character.isDigit(c)) {
                // 指定字符为数字,k可能不止一位数
                k = k * 10 + c - '0';
            } else if (c == '[') {
                // 如果是[
                k_stack.push(k);
                pre_stack.push(res);
                k = 0; // 将k和res都清空，因为后面可能会有新的数字和字符
                res = new StringBuilder();
            } else if (c == ']') {
                int k_curr = k_stack.pop();
                // 与当前数字k_curr前面的字符进行合并
                StringBuilder temp = pre_stack.pop();
                for (int i = 0; i < k_curr; i++) {
                    temp.append(res);
                }
                res = temp;
            }
        }
        return res.toString();
    }
}
