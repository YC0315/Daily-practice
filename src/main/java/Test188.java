import java.util.Arrays;

/**
 * @author: yangchao
 * @createTime: 2022-08-21  15:08
 * @description: 分割等和子集
 * 给你一个 只包含正整数 的 非空 数组 nums 。
 * 请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 */
public class Test188 {
    public boolean canPartition(int[] nums) {
        // 求和
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 == 0) return true;
        return false;
    }
}
