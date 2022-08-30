/**
 * @author: yangchao
 * @createTime: 2022-08-29  16:32
 * @description: 最大的正方形
 */
public class Test213 {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int res = 0;
        int m = matrix.length, n = matrix[0].length;
        // 定义状态：dp[i][j]为以 matrix[i-1][j-1] 为右下角的正方形的最大矩形边长
        // 初始状态
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 检查当前方块的左侧，上侧，左上侧的方块
                // 因为i和j从1开始的，因此要从matrix[i-1][j-1]开始
                if (matrix[i - 1][j - 1] == '1') {
                    // 状态转移
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    res = Math.max(res, dp[i][j] * dp[i][j]);
                }
            }
        }
        return res;
    }
}
