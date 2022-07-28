/**
 * @author: yangchao
 * @createTime: 2022-07-21  19:34
 * @description: 岛屿的最大面积
 */
public class Test80 {
    public int maxAreaOfIsland(int[][] grid) {
        // 借助感染的思想
        int maxGrid = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int res = infect(grid, i, j);  // 计算每次感染的方格数
                    maxGrid = Math.max(maxGrid, res);  // 取每个岛屿的最大面积
                }
            }
        }
        return maxGrid;
    }
    private int infect(int[][] grid, int i, int j) {
        int temp= 1;  // 每次感染的岛屿的数量是从1开始的，因为当前方格已经为1了！！
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) return 0;
        grid[i][j] = 2;  // 将当前方格置成2，防止重复遍历
        temp += infect(grid, i - 1, j)
                + infect(grid, i + 1, j)
                + infect(grid, i, j - 1)
                + infect(grid, i, j + 1);
        return temp;
    }
}
