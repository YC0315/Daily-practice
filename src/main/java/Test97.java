/**
 * @author: yangchao
 * @createTime: 2022-07-27  19:15
 * @description: 判断s是不是t的子序列（子序列不是连续的子串）
 */
public class Test97 {
    // 使用动态规划
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) return true;
        int m = s.length();
        int n = t.length();
        int maxLen = 0;
        boolean flag = false;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
                maxLen = Math.max(maxLen, dp[i][j]);
                if (maxLen == m) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    // 使用双指针
    public boolean isSubsequence1(String s, String t) {
        int i = 0;
        int j = 0;
        int m = s.length();
        int n = t.length();
        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == m;
    }


    // 使用内置函数
    public boolean isSubsequence2(String s, String t) {
        int ans = -1;
        for (int i = 0; i < s.length(); i++) {
            // 返回指定字符str在字符串中（方法调用者）第一次出现处的起始索引
            // 当indexOf()没有这个字符串时，会返回-1
            ans = t.indexOf(s.charAt(i), ans + 1);
            if (ans == -1) return false;
        }
        return false;
    }

}
