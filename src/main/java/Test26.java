import java.util.HashMap;

/**
 * @author: yangchao
 * @createTime: 2022-06-26  20:47
 * @description: 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 */
public class Test26 {
    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        int paths = uniquePaths(m, n);
        System.out.println(paths);
    }
    // 使用动态规划
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] += 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
    /*
    // 纯用递归是不行的，因为有大量的重复调用会导致超时，加个HashMap缓存就可以了。
    // 使用递归法，每次将数据缓存到HashMap中，避免重复搜索
    public static int uniquePath(int m, int n){
        return dfs(new HashMap<Pair,Integer>(), 0, 0, m, n);
    }

    private static int dfs(HashMap<Pair, Integer> cache, int i, int j, int m, int n) {
        Pair pair = new Pair(i, j);
        // 如果（i, j）在缓存中，则直接从HashMap中取，避免重复搜索
        if(cache.containsKey(pair)){
            return cache.get(pair);
        }
        // 递归的边界条件
        if(i == m-1 || j == n-1){
            return 1;
        }
        // 将此次遍历的值放入缓存中,并且接着往下遍历，往右j+1，往下i+1
        cache.put(pair, dfs(cache, i+1, j, m, n)+dfs(cache, i, j+1, m, n));
        // 从缓存中取出累积的和
        return cache.get(pair);
    }
    */

}
