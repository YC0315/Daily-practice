/**
 * 最长回文子串baab,ababa..
 */
public class Test12 {
    public String longestPalindrome(String s) {
        // 先判空在查看大小，否则会可能出现空指针异常，字符串的长度要使用length()方法！length是数组的属性
        if (s == null || s.length() <= 1) {
            return s;
        }
        // 记录最长回文子串
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 每次都去检查奇偶两种情况
            // 假如回文串是奇数
            String s1 = search(s, i, i);
            // 假如回文串是偶数
            String s2 = search(s, i, i + 1);
            // 三元运算符：判断为真时取冒号前面的值，为假时取冒号后面的值
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    private String search(String s, int left, int right) {
        while (left >= 0 && right <= s.length() - 1) {
            // 不要再将字符串转换成字符数组了！！，直接使用s.charAt(index)获取索引处的值
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return s.substring(left + 1, right); // left和right已经--++了， 所以要在[left+1, right)之间！不包含右边界
    }
}
