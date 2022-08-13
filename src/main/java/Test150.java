/**
 * @author: yangchao
 * @createTime: 2022-08-12  20:05
 * @description: 和为 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的'连续子数组'的个数 。
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 */
public class Test150 {
    public static void main(String[] args) {
        int[] nums = {-1, -1, 1};
        int k = 0;
        int i = subarraySum(nums, k);
        System.out.println(i);
    }

    public static int subarraySum(int[] nums, int k) {
        // 双指针不能用，因为有负数，区间值不单调变化,用两层for循环枚举
        int n = nums.length;
        int count = 0;
        // 暴力法两层for循环，从后往前遍历，求解每一个end-start之间连续数字的和
        for (int start = n-1; start >= 0; start--) {
            int sum = 0; // 记录连续数字和
            for (int end = start; end >= 0; end--) {
                sum += nums[end];
                if(sum == k) count++;
            }
        }
        return count;
    }
}
