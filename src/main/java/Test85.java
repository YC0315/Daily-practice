/**
 * @author: yangchao
 * @createTime: 2022-07-21  22:07
 * @description: 最长回文子串，是在回文子串上扩展来的，只需要额外判断回文子串的长度，返回最大值即可
 */
public class Test85 {
    // 1.返回最长回文子串的长度
    // 使用动态规划
    public int getLongestPalindrome(String A) {
        int res = 0;
        int length = A.length() - 1;
        boolean[][] dp = new boolean[length + 1][length + 1];
        for (int i = length; i >= 0; i--) {
            for (int j = i; j <= length; j++) {
                if (A.charAt(i) == A.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }

    // 使用中心扩展法
    int res = 0;

    public int getLongestPalindrome1(String A) {
        for (int i = 0; i < A.length(); i++) {
            count(A, i, i);
            count(A, i, i + 1);
        }
        return res;
    }

    private void count(String a, int start, int end) {
        while (start >= 0 && end < a.length() && a.charAt(start) == a.charAt(end)) {
            res = Math.max(res, end - start + 1);
            start--;
            end++;
        }
    }
}
