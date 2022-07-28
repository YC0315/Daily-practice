/**
 * @author: yangchao
 * @createTime: 2022-07-19  18:59
 * @description: 最长公共子序列和最长公共子串
 */
public class Test68 {
    // 最长公共子序列和最长公共子串问题都要借助二维数组使用动态规划
    public static int longestCommonSubsequence(String text1, String text2) {
        // 最长公共子序列不要求子序列连续
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 从第0个字符进行比较
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }

    // 最长公共子串要求子串必须连续,如果要返回最长子串的长度
    public int LCS(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        // 定义一个变量记录二维数组中的最大值，因为最大值可能不在数组最末尾
        int res = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 从第0个字符进行比较
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);  // 最长子串的长度
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return res;
    }

    // 最长公共子串要求子串必须连续,如果要返回最长子串
    public String LCS1(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        // 记录最长子串的长度
        int maxLen = 0;
        // 记录最长子串最后一个元素的索引
        int maxIndex = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 从第0个字符进行比较
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                        maxIndex = i - 1;   // 最长子串的最后一个元素的索引，是i-1而不是i
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        // 返回最长子串
        return str1.substring(maxIndex - maxLen + 1, maxIndex + 1);  // subString(from,to)不包括to
    }

}