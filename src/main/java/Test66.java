/**
 * @author: yangchao
 * @createTime: 2022-07-18  20:56
 * @description: 最长公共子序列, 子序列不一定连续
 */
public class Test66 {
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];  // 申请多一行多一列，方便计算边界值
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {  // 这块字符串的索引是从0开始的
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        int i = longestCommonSubsequence("abcde", "abc");
        System.out.println(i);
    }
}
