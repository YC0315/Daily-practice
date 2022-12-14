import java.util.HashSet;
import java.util.Set;

/**
 * @author: yangchao
 * @createTime: 2022-08-08  08:19
 * @description: 无重复字符的最长子串的长度
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class Test128 {
    public int lengthOfLongestSubstring(String s) {
        int m = s.length();
        Set<Character> set = new HashSet<>();
        int res = 0;
        int left = 0, right = 0;
        // 使用滑动窗口，while循环的退出条件就是右边界到达字符串末端
        while (right < m) {
            // 里面是if循环，外层是while循环
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
            }else{
                set.remove(s.charAt(left));
                left++;
            }
            res = Math.max(res, set.size());
        }
        return res;
    }
}
