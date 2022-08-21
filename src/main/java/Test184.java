import java.util.Arrays;

/**
 * @author: yangchao
 * @createTime: 2022-08-19  15:39
 * @description: 最长递增子序列
 */
public class Test184 {
    public int maxSubLTS(int[] nums) {
        int n = nums.length;
        // 使用动态规划+二分查找
        int[] dp = new int[n];
        int maxLen = 1;
        Arrays.fill(nums, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    // 以上使用动态规划的时间复杂度是n2，下面用动态规划+二分查找
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        // 将第一个元素放入arr作为一个起始点
        arr[0] = nums[0];
        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > arr[maxLen - 1]) { // 检查是否大于arr的最大值
                arr[maxLen] = nums[i]; // 将元素插入arr最后一位，作为最大值
                maxLen++;
                continue;
            } else {
                // 比arr最大元素小，就替换掉arr里面第一个比nums[i]大的元素
                // 使用二分查找，找到第一个比nums[i]元素大的位置
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
        }
        return maxLen;
    }
}
