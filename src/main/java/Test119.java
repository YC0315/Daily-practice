/**
 * @author: yangchao
 * @createTime: 2022-08-02  21:09
 * @description: 最小路径之和
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：一个机器人每次只能向下或者向右移动一步!!  只能向下或向右走
 */
public class Test119 {
    // 动态规划，自上而下的
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];  // 每个格子记录走过的路径和
        // 前两个for循环是边界条件！！
        // 第一列只能由上往下
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        // 第一行只能由左到右
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        // 其余点的最优目标 只要比较左边和上面的最优路径权重+该点权重
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    // dfs解法,自下而上的
    int[][] grid;
    public int minPathSum1(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        this.grid = grid; // 这块要指定成员变量就是参数传进来的二维矩阵
        return sum(m - 1, n - 1);
    }

    private int sum(int i, int j) {
        // 递归出口
        if (i == 0 && j == 0) return grid[0][0];
        // 边界条件，因为要找最小值，所以这块可以设置成整形最大值
        if (i < 0 || j < 0) return Integer.MAX_VALUE;
        // 递归，返回倒数第二步的最小值加当前值！！
        return Math.min(sum(i - 1, j), sum(i, j - 1)) + grid[i][j];
    }
}
