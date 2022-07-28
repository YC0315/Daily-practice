/**
 * @author: yangchao
 * @createTime: 2022-07-18  22:10
 * @description: 最长公共子串,要求子串连续
 */
public class Test67 {
    public static int LCS(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int res = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s1 = "1AB2345CD";
        String s2 ="12345EF";
        System.out.println(LCS(s1, s2));
    }
}
