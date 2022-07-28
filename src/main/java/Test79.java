/**
 * @author: yangchao
 * @createTime: 2022-07-21  19:23
 * @description: 岛屿周长
 */
public class Test79 {
    // dfs遍历数组，只要前面有相邻的方格，就-2
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res += 4;
                    // 在当前网格满足要求的前提下，只看右边和下面是否满足要求
                    if (i+1 < grid.length && grid[i+1][j] == 1) res -= 2;
                    if (j+1 < grid[0].length && grid[i][j+1] == 1) res -= 2;
                }
            }
        }
        return res;
    }

}
