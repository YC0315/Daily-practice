import java.util.Arrays;
import java.util.Map;

/**
 * @author: yangchao
 * @createTime: 2022-08-18  19:43
 * @description: 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列，子序列不是子串，不要求连续
 */
public class Test181 {
    // 和最长子序列没区别，使用动态规划
    public int lengthOfLIS(int[] nums) {
        // 子序列问题，要是用动态规划
        int n = nums.length;
        int maxLen = 1;
        // 使用数组 dp 保存每步子问题的最优解
        // dp[i] 代表含第 i 个元素的最长上升子序列的长度
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // 将数组都填充为1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1); // 之所以还要比较dp[i]是为了保证是递增的子序列，只使用dp[j]+1，不能保证递增比如[0, 1, 0, 3, 2]
                }
            }
            maxLen = Math.max(dp[i], maxLen);
        }
        return maxLen;
    }

    public int lengthOfLIS1(int[] nums) {
        int n = nums.length;
        if (n < 2) return n;
        // 维护一个递增数组，用于保存最长上升子序列
        // 若当前元素 num 比 arr 中最后一个元素大，则直接将其插入 cell;
        // 否则，将 arr 中比 num 大的第一个元素替换为 num
        int[] arr = new int[n];
        arr[0] = nums[0];
        int maxLen = 1; //
        for (int i = 1; i < n; i++) {
            if (nums[i] > arr[maxLen - 1]) {
                arr[maxLen] = nums[i];
                maxLen++;
                continue;
            }
            // 否则，二分查找arr中第一个比num大的元素
            int left = 0;
            int right = maxLen - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] >= nums[i]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            arr[left] = nums[i];
        }
        return maxLen;
    }
}