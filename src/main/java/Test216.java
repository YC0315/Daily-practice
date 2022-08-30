/**
 * @author: yangchao
 * @createTime: 2022-08-30  08:45
 * @description: 最大的正方形的面积
 */
public class Test216 {
    public int maximalSquare(char[][] matrix) {
        // 使用动态规划做
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int res = 0;
        int[][] dp = new int[m + 1][n + 1];  // 动态数组大多数都要多建一行和一列
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 这块是i-1,j-1要从第0个元素开始判断
                if (matrix[i - 1][j - 1] == '1') {
                    // 不要忘了加上一次的最小的正方形的边长+1
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    // 返回的是面积值
                    res = Math.max(res, dp[i][j] * dp[i][j]);
                }
            }
        }
        return res;
    }
}
