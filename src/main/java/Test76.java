/**
 * @author: yangchao
 * @createTime: 2022-07-20  21:27
 * @description: 岛屿的周长，岛屿问题都使用深度优先搜索
 */
public class Test76 {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }

    // 深度优先搜索
    private int dfs(int[][] grid, int i, int j) {
        // 如果走到了边缘
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return 1;
        // 如果走到了湖泊
        if (grid[i][j] == 0) return 1;
        // 如果走到了已经访问过的
        if (grid[i][j] == 2) return 0;
        grid[i][j] = 2;
        return dfs(grid, i - 1, j) + dfs(grid, i, j - 1)
                + dfs(grid, i + 1, j) + dfs(grid, i, j + 1);
    }

    // 也可以遍历每个格子
    public int islandPerimeter1(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res += 4;
                    // 方格A和方格B相邻，方格A，B需要分别减少一条边
                    if (i + 1 < grid.length && grid[i + 1][j] == 1) res = res - 2;
                    if (j + 1 < grid[i].length && grid[i][j + 1] == 1) res = res - 2;
                }
            }
        }
        return res;
    }

}
