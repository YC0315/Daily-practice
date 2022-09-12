/**
 * @author: yangchao
 * @createTime: 2022-09-08  19:44
 * @description: TODO
 */
public class Test258 {
    public int maximumTotal(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle.length];
        //return dongGui(triangle, dp);
//      return dfs(triangle, 0, 0);
        int m = triangle.length;
        int[] dp1 = new int[m + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp1[j] = triangle[i][j] + Math.min(dp1[j], dp1[j + 1]);
            }
        }
        return dp1[0];
    }

    public int dongGui(int[][] arr, int[][] vs) {
        int n = arr.length;
        for (int j = 0; j < n; j++) {
            vs[n - 1][j] = arr[n - 1][j];
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int v1 = arr[i][j] + vs[i + 1][j];
                int v2 = arr[i][j] + vs[i + 1][j + 1];
                vs[i][j] = Math.max(v1, v2);
            }
        }
        return vs[0][0];
    }

    public int dfs(int[][] arr, int row, int col) {
        if (row == arr.length - 1) {
            return arr[row][col];
        }
        int v1 = arr[row][col] + dfs(arr, row + 1, col);
        int v2 = arr[row][col] + dfs(arr, row, col + 1);
        return Math.max(v1, v2);
    }


}
