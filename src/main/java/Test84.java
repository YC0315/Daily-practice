/**
 * @author: yangchao
 * @createTime: 2022-07-21  21:17
 * @description: 回文子串
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 * 回文字符串 是正着读和倒过来读一样的字符串。
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 */
public class Test84 {
    int num = 0;
    public int countSubstrings(String s) {
        // 使用中心拓展法，要区分奇数偶数
        // 以每一个字符为中心向两侧拓展
        for (int i = 0; i < s.length(); i++) {
            count(s, i, i); // 回文串长度为奇数
            count(s, i, i + 1); // 回文串长度为偶数
        }
        return num;
    }

    private void count(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            num++;
            start--;
            end++;
        }
    }

    // 也可以使用动态规划
    public int countSubstrings1(String s) {
        int res = 0;
        int length = s.length() - 1;
        // dp[i][j] 表示[i,j]的字符是否为回文子串
        boolean[][] dp = new boolean[length + 1][length + 1];

        // 外层循环倒着写，内层循环正着写,因为要求dp[i][j] 需要知道dp[i+1][j-1]
        // 当我们判断 [i,j] 是否为回文子串时，只需要判断 s[i] == s[j]，同时判断 [i+1,j-1] 是否为回文子串即可
        for (int i = length; i >= 0; i--) {
            for (int j = i; j <= length; j++) {
                // (s.charAt(i)==s.charAt(j) 时,当元素个数为1,2,3个时，一定为回文子串
                // 如果元素个数大于3，那么就看上一个子串是不是回文串
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    res++;
                }
            }
        }
        return res;
    }
}
