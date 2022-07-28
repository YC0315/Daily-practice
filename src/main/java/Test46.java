import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: yangchao
 * @createTime: 2022-07-11  19:18
 * @description: 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 */
public class Test46 {
    public String convert(String s, int numRows) {
        if(numRows < 2) return s;
        // 创建numRows个字符串用于存放最终子串,首先用一个列表去存储这些字符串
        List<StringBuilder> res = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            res.add(new StringBuilder());
        }
        int j = 0;
        int flag = 1;
        for (char c : s.toCharArray()) {
            res.get(j).append(c);
            j += flag;
            if (j == numRows - 1 || j == 0){
                flag = - flag;
            }
        }
        // 将列表中的子串拼成一个字符串
        StringBuilder result = new StringBuilder();
        for (StringBuilder re : res) {
            result.append(re);
        }
        return result.toString();
    }
}
