import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yangchao
 * @createTime: 2022-09-16  15:30
 * @description: 零钱兑换
 */
public class Test264 {
    public static void main(String[] args) {
        int[] coins = {411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422};
        int amount = 9846;
        int i = coinChange1(coins, amount);
        System.out.println(i);
    }


    static int res = Integer.MAX_VALUE;
    static List<Integer> temp = new ArrayList<>();

    public static int coinChange(int[] coins, int amount) {
        // 无重复元素的组合问题，可以重复选取
        if (amount == 0) return -1;
        backTrack(coins, amount, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void backTrack(int[] coins, int target, int index) {
        if (target == 0) {
            int size = temp.size();
            res = Math.min(res, size);
        }

        for (int i = index; i < coins.length; i++) {
            if (target > 0) {
                temp.add(coins[i]);
                backTrack(coins, target - coins[i], i);
                temp.remove(temp.size() - 1);
            }
        }
    }

    // 使用动态规划
    public static int coinChange1(int[] coins, int amount) {
        int max = amount + 1;
        // 初始化一个长度为12，用来存储状态的数组，默认值填充为amount+1,也可以填充为最大值，用来后续比较。
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        //设置初始0的最少硬币为0
        dp[0] = 0;
        //分别处理标记dp中0-amount的状态值
        for (int i = 1; i <= amount; i++) {
            // 用不同的硬币种类去判断各种情况
            for (int j = 0; j < coins.length; j++) {
                // 如果当前金额大于当前判断的硬币
                if (coins[j] <= i) {
                    // dp[i-coins[j]]获得该价格下的最优数量
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        // 是否初始化的值，如果是初始值说明没有兑换成功
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
