/**
 * @author: yangchao
 * @createTime: 2022-08-07  19:53
 * @description: 最长公共子串
 */
public class Test127 {
    public static void main(String[] args) {
        String str1 = "1AB2345CD";
        String str2 = "12345EF";
        String lcs = LCS(str1, str2);
        System.out.println(lcs);
    }

    public static String LCS(String str1, String str2) {
        int maxIndex = 0, len = 0;  // 这块不能记录左右下标，因为i，j始终是靠着的，dp里面记录的是长度值
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > len) {
                        len = dp[i][j];
                        maxIndex = i-1;  // 这块是i-1因为if条件里的索引是i-1，并且最后返回的是str1的子串，写成j-1的话就要返回str2的子串
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return str1.substring(maxIndex - len + 1, maxIndex + 1);
    }
}
