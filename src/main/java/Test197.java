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
    /*
     * 解法：
        原数组：       [1       2       3       4]
        左部分的乘积：  1       1      1*2    1*2*3
        右部分的乘积： 2*3*4    3*4      4      1
        结果：        1*2*3*4  1*3*4   1*2*4  1*2*3*1
     **/
    // 时间复杂度O(N), 空间复杂度O(N)
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        // i元素的前缀积和后缀积相乘，计算前缀积数组和后缀积数组，然后相乘
        int[] l = new int[n];
        int[] r = new int[n];

        int[] result = new int[n];
        // 计算前缀积
        // L[i] 为索引 i 左侧所有元素的乘积
        // 对于索引为 '0' 的元素，因为左侧没有元素，所以 L[0] = 1， 左边第一个元素是1
        l[0] = 1;
        for (int i = 1; i < n; i++) {
            l[i] = l[i-1] * nums[i-1];
        }
        // 计算后缀积
        // R[i] 为索引 i 右侧所有元素的乘积
        // 对于索引为 'length-1' 的元素，因为右侧没有元素，所以 R[length-1] = 1，右边第一个元素是1
        r[n-1] = 1;
        for(int i = n-2; i>=0; i--){
            r[i] = r[i+1]*nums[i+1];
        }
        // 计算最终结果，前缀积乘后缀积，对于索引 i，除 nums[i] 之外其余各元素的乘积就是左侧所有元素的乘积乘以右侧所有元素的乘积
        for(int i = 0; i < n; i++){
            result[i] = l[i] * r[i];
        }
        return result;
    }

    // 优化上述代码到空间复杂度O(1)， 不额外创建数组L,R而是复用result
    public int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i-1] * nums[i-1];
        }

        // R为i元素右侧所有元素的乘积
        int R = 1;
        for(int j = n-1; j >= 0; j--){
            result[j] = result[j] * R;
            R = R * nums[j];
        }
        return result;
    }
}
