/**
 * @author: yangchao
 * @createTime: 2022-07-29  08:05
 * @description: 最长回文子串，返回子串，不是长度
 */
public class Test105 {
    public String longestPalindrome(String s) {
        // 使用动态规划
        int n = s.length();
        int maxLen = 0;
        int maxIndex = 0;
        // 标记上一个子串是否是回文子串
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 2 || dp[i + 1][j - 1] == 1) {
                        dp[i][j] = 1;
                        if (maxLen < j - i + 1) {
                            maxLen = j - i + 1;
                            maxIndex = j;
                        }
                    }
                }
            }
        }
        return s.substring(maxIndex - maxLen + 1, maxIndex + 1);
    }

    // 使用中心拓展法
    // 记录最长回文子串的左右下标
    int left = 0;
    int right = 0;
    // 不要使用s.toCharArray().length这种方式，会增加100多毫秒的时间，要单独定义长度
    public String longestPalindrome1(String s) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            count(s, i, i);
            count(s, i, i + 1);
        }
        return s.substring(left, right + 1);
    }

    public void count(String s, int start, int end) {
        while (start >= 0 && end <= s.length() - 1 && s.charAt(start) == s.charAt(end)) {
            if (right - left + 1 < end - start + 1) {
                left = start;
                right = end;
            }
            start--;
            end++;
        }
    }

}
