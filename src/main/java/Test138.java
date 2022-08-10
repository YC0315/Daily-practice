/**
 * @author: yangchao
 * @createTime: 2022-08-10  20:12
 * @description: 一维数组的动态和
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,6,10]
 * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4]
 */
public class Test138 {
    public int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        int a = 0; // 用一个变量动态的记录每一次相加的和
        for (int i = 0; i < res.length; i++) {
            int c = a + nums[i];
            res[i] = c;
            a = c;
        }
        return res;
    }
}
