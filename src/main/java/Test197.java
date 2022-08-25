/**
 * @author: yangchao
 * @createTime: 2022-08-25  16:29
 * @description: 除自身以外数组的乘积
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 */
public class Test197 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        // i元素的前缀积和后缀积相乘，计算前缀积数组和后缀积数组，然后相乘
        int[] l = new int[n];
        int[] r = new int[n];

        int[] result = new int[n];
        // 计算前缀积
        l[0] = 1;
        for (int i = 1; i < n; i++) {
            l[i] = l[i-1] * nums[i-1];
        }
        // 计算后缀积
        r[n-1] = 1;
        for(int i = n-2; i>=0; i--){
            r[i] = r[i+1]*nums[i+1];
        }
        // 计算最终结果，前缀积乘后缀积
        for(int i = 0; i < n; i++){
            result[i] = l[i] * r[i];
        }
        return result;
    }
}
