import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: yangchao
 * @createTime: 2022-06-27  19:27
 * @description: 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 你的输出需要从左往右逐行读取，产生出一个新的字符串
 */
public class Test27 {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        String convert = convert(s, 3);
        System.out.println(convert);
    }

    public static String convert(String s, int numRows) {
        // 如果给定的行数n小于2，则直接返回字符串
        if (s.length() < 2) {
            return s;
        }
        // 一个数组，存放更新后每一行的字符串,先生成n个空做的字符串
        List<StringBuilder> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            res.add(new StringBuilder()); // 不能使用""这种空字符串的形式，因为String类型的字符串不可变
        }
        int j = 0;
        int flag = 1;  // 转换方向的标识
        for (char c : s.toCharArray()) {
            res.get(j).append(c); // 依次将每个字符加入所在行的数组字符串中
            j += flag;
            // 当到达最后一行或者第一行时转向,使用flag控制i增大还是减小
            if (j == numRows - 1 || j == 0) {
                flag = -flag;
            }
        }
        // 将字符集合中的n个字符串加起来
        StringBuilder sb = new StringBuilder();
        for (StringBuilder re : res) {
            sb.append(re);
        }
        return sb.toString();
    }
}
