import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: yangchao
 * @createTime: 2022-07-27  08:06
 * @description: 字符串的全排列，含有重复字符，要求最终返回的数组中不能有重复元素
 * 输入："abc"
 * 返回值：["abc","acb","bac","bca","cab","cba"]
 */
public class Test96 {
    // 采用回溯加标记的方式
    ArrayList<String> res = new ArrayList<>();
    public ArrayList<String> Permutation(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        // 创建一个临时字符串存储中间值
        StringBuffer temp = new StringBuffer();
        // 标记数组用来标记当前元素是不是已经使用过
        boolean[] vis = new boolean[chars.length];
        backtrack(chars, temp, vis, 0);
        return res;

    }
    // index是指第几个空位
    public void backtrack(char[] chars, StringBuffer temp, boolean[] vis, int index) {
        // 结束条件
        if (index == chars.length) {
            if (!res.contains(temp.toString())) {
                res.add(temp.toString());
            }
        }
        // 做选择
        // 使用一个标记prev，标记不使用重复元素，在递归函数中设定一个规则，
        // 保证在填每一个空位的时候重复字符只会被填入一次
        int prev = -11;
        for (int i = 0; i < chars.length; i++) {
            if (prev == chars[i] || vis[i]) continue;  // 当前元素没有用过，或者是重复的元素

            // 标记当前元素已经用过
            prev = chars[i];
            // 做选择
            temp.append(chars[i]);
            vis[i] = true;
            backtrack(chars, temp, vis, index + 1);
            // 撤销选择
            vis[i] = false;
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
