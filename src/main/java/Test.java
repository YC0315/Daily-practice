import java.util.*;

/**
 * 无重复的最长子串
 */
public class Test {
    private static int lengthOfLongestSubstring(String s) {
        int res = 0;
        if (s == null || s.length() == 0) {
            return res;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            int j = i + 1;
            Map<Character, Integer> map = new HashMap<>();
            map.put(chars[i], 1);
            while (j <= chars.length - 1 && map.get(chars[j]) == null) {
                map.put(chars[j], 1);
                j++;
            }
            res = Math.max(res, (j - i));
        }
        return res;
    }

    // 滑动窗口方法
    private static int lengthOfLongestSubstring1(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>(); // map中存放的是当前字符以及字符的索引

        int res = 0;
        int left = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);   // 假如窗口里面包含当前值，就让窗口左端移动到窗口中包含当前值的位置的下一个位置
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i - left + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int substring = lengthOfLongestSubstring(s);
        System.out.println(substring);


    }
}
