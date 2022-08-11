/**
 * @author: yangchao
 * @createTime: 2022-08-11  20:48
 * @description: 岛屿数量
 */
public class Test146 {
    public int numIslands(char[][] grid) {
        // 利用感染的思想
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    infect(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public void infect(char[][] grid, int i, int j) {
        // 当不满足哪些条件时就退出，检查不满足的条件
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') return;
        grid[i][j] = '2';
        infect(grid, i + 1, j);
        infect(grid, i, j + 1);
        infect(grid, i - 1, j);
        infect(grid, i, j - 1);
    }
}
