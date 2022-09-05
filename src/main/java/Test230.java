import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: yangchao
 * @createTime: 2022-09-01  08:21
 * @description: 最长递增子序列
 */
public class Test230 {
    public static void main(String[] args) {
        int[] num = {1,3,5,4,7};
        //int lengthOfLIS = lengthOfLIS(num);
        int numberOfLIS = findNumberOfLIS(num);
        System.out.println(numberOfLIS);
    }

    public static int lengthOfLIS(int[] nums) {
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
            // 记录每一个位置处的最长递增子序列取最大值
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    // 也可以使用二分查找法，使得时间复杂度为0(nlgn)
    public static int lenthOfLIS(int[] nums) {

        return -1;
    }

    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int res = 1;  // 记录最长递增子序列的个数,因为最小也是当前自己的一个数，因此res的初始值为1
        int[] dp = new int[n]; //  dp[i] 为考虑以 nums[i] 为结尾的最长上升子序列的长度
        int[] gn = new int[n]; //  gn[i] 为考虑以 nums[i] 结尾的最长上升子序列的个数
        Arrays.fill(dp, 1); // 代表最长递增子序列的长度至少为1
        Arrays.fill(gn, 1); // 代表最长递增子序列的个数至少为1
        // 记录最长递增子序列的长度和个数
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if(dp[i] < dp[j] +1){
                        dp[i] = dp[j]+1;
                        gn[i] = gn[j];  // 个数就等于上一个元素对应的最长递增子序列的个数
                    }else  if(dp[i] == dp[j] + 1){
                        gn[i] += gn[j]; // 上一个最长递增子序列的个数加1
                    }
                }
            }
            res = Math.max(res, dp[i]);
        }
        int ans = 0;
        for(int m = 0; m < n; m++){
            // 如果当前元素的最长递增子序列的长度等于最大值，那么久将其对应的最长递增子序列的个数进行累加
            if(dp[m] == res){
                ans += gn[m];
            }
        }
        return ans;
    }
}
