
/**
 * @author: yangchao
 * @createTime: 2022-08-07  19:08
 * @description: 最长回文子串
 */
public class Test125 {
    int left = 0, right = 0;

    public String longestPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            check(i, i, s);
            check(i, i + 1, s);
        }
        return s.substring(left, right + 1);
    }

    public void check(int i, int j, String s) {
        while (i >= 0 && j <= s.length() - 1) {
            if (s.charAt(i) == s.charAt(j)) {
                if ((right - left) < (j - i)) {
                    left = i;
                    right = j;
                }
                i--;
                j++;
            } else {
                // 这里不要忘了，不加上break的话会做很多无用的遍历
                break;
            }
        }
    }

    // 使用动态规划
    public String longestPalindrome1(String s) {
        int m = s.length();
        boolean[][] dp = new boolean[m][m];  // 二维数组
        for (int i = m - 1; i >= 0; i--) {
            for (int j = i; j <= m - 1; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 2 || dp[i + 1][j - 1]) {  // 假如当前子串个数小于2或者大于二但是前一个子串是回文串
                        dp[i][j] = true;
                        if ((right - left) < (j - i)) {
                            left = i;
                            right = j;
                        }
                    }
                } else {
                    // 如果不相等则直接跳过这次循环
                    continue;
                }
            }
        }
        return s.substring(left, right + 1);
    }
}
