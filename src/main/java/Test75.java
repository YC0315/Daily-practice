/**
 * @author: yangchao
 * @createTime: 2022-07-20  20:45
 * @description: 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 */
public class Test75 {
    // 岛屿问题要想到用深度优先搜索，也称感染法
    public int numIslands(char[][] grid) {
        int isLandsNumber = 0;
        if (grid == null || grid.length == 0) return 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    // 一次感染一座岛屿
                    // 对当前位置进行深度优先遍历，遍历该位置所在岛屿的所有相邻位置，
                    infect(grid, i, j);
                    isLandsNumber++;
                }
            }
        }
        return isLandsNumber;
    }

    private void infect(char[][] grid, int i, int j) {
        // 这个顺序不能换
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') return;

        // 感染当前位置
        grid[i][j] = '2';
        // 并由当前位置向四周扩散
        infect(grid, i, j + 1);
        infect(grid, i + 1, j);
        infect(grid, i - 1, j);
        infect(grid, i, j - 1);
    }

    // 上面这种方法修改了原数组，加入要求不修改原数组的话，可以额外维护一个标记数组
    public int numIslands1(char[][] grid) {
        int isLandsNumber = 0;
        if (grid == null || grid.length == 0) return 0;
        // 标记数组初始元素都是'0',当元素是'1'时说明已经遍历过了，不需要再遍历
        char[][] visited = new char[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && visited[i][j] != '1') {
                    // 一次感染一座岛屿
                    // 对当前位置进行深度优先遍历，遍历该位置所在岛屿的所有相邻位置，
                    infect1(grid, i, j, visited);
                    isLandsNumber++;
                }
            }
        }
        return isLandsNumber;
    }

    private void infect1(char[][] grid, int i, int j, char[][] visited) {
        // 这个顺序不能换
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0' || visited[i][j] == '1') return;

        // 感染当前位置,修改标记数组，不修改原数组
        visited[i][j] = '1';
        // 并由当前位置向四周扩散
        infect1(grid, i, j + 1, visited);
        infect1(grid, i + 1, j, visited);
        infect1(grid, i - 1, j, visited);
        infect1(grid, i, j - 1, visited);
    }
}
