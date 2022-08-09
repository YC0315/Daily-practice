import java.util.*;

/**
 * @author: yangchao
 * @createTime: 2022-08-07  19:38
 * @description: 无重复字符的最长子串的长度
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class Test126 {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;  // 构建一个滑动窗口，使用两个指针维护左右窗口端点
        int res = 0;
        // 维护当前最长不重复字符子串
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            if(!set.contains(s.charAt(right))){
                // 未查到重复字符就一直加，right右移
                set.add(s.charAt(right));
                right++;
            }else{
                set.remove(s.charAt(left));  // 从set最左端开始移除元素，直到移除完重复的元素，不能直接弹出重复元素，这样set里剩下的元素就不是子串了
                left++;
            }
            // 每一次计算当前set子串的长度
            res = Math.max(res, set.size());
        }
        return res;
    }
}
