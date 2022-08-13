/**
 * @author: yangchao
 * @createTime: 2022-08-13  08:03
 * @description: 和为 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的'连续子数组'的个数 。
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 */
public class Test152 {
    // 因为k可能为负数，因此不能使用双指针或者滑动窗口,尽量不要定义成静态方法，测试时很占时间
    public int subarraySum(int[] nums, int k) {
        // 暴力法两层for循环
        int n = nums.length - 1;
        int count = 0;
        for (int start = n; start >= 0; start--) {
            int sum = 0;
            for(int end = start; end >= 0; end--){
                sum += nums[end];  // 判断连续子数组的和是否等于k
                if(sum == k) count++;
            }
        }
        return count;
    }
}
