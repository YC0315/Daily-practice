import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: yangchao
 * @createTime: 2022-09-01  08:21
 * @description: 最长递增子序列的个数
 */
public class Test230 {
    public static void main(String[] args) {
        int[] num = {10, 9, 2, 5, 3, 7, 101, 18};
        int lengthOfLIS = lengthOfLIS(num);
        System.out.println(lengthOfLIS);
    }

    public static int lengthOfLIS(int[] nums) {
        // 先计算最长递增子序列，统计子序列的个数，使用动态规划
        // dp[i]表示第i个位置的最长子序列个数
        int n = nums.length;
        int res = 1;  // 记录最长递增子序列的个数,因为最小也是当前自己的一个数，因此res的初始值为1
        int[] dp = new int[n];
        // dp数组中都设置为1，因为一个元素的最长递增子序列就是它自己
        // 使用Arrays的api去填充1
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    // 也可以使用二分查找法，使得时间复杂度为0(nlgn)
    public static int lenthOfLIS(int[] nums) {
        // 使用二分查找
        return -1;
    }
}
