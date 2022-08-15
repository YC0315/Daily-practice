/**
 * @author: yangchao
 * @createTime: 2022-08-14  19:41
 * @description: 最长回文子串
 */
public class Test160 {
    // 可以使用中心拓展法或者动态规划
    int maxLen = 0;
    int maxIndex = 0;

    public String longestPalindrome(String s) {
        int n = s.length();
        // 使用一个二维数组记录上一位置是否为回文串
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        // 记录索引
                        if ((j - i + 1) > maxLen) {
                            maxLen = j - i + 1;
                            maxIndex = j;
                        }
                    }
                }
            }
        }
        return s.substring(maxIndex - maxLen + 1, maxIndex + 1);
    }
}
