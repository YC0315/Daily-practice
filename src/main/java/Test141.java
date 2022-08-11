import java.util.Random;

/**
 * @author: yangchao
 * @createTime: 2022-08-11  08:28
 * @description: 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 */
public class Test141 {
    // 优化后的快排
    static Random random = new Random();
    public static int findKthLargest(int[] nums, int k) {
        return quickSorted(nums, k, 0, nums.length - 1);
    }
    public static int quickSorted(int[] nums, int k, int left, int right) {
        int start = left;
        int end = right;
        // 选定基准
        int index = random.nextInt(right - left + 1) + left;
        int prior = nums[index];
        nums[index] = nums[left];

        while (left < right) {
            // 逆序排
            while (left < right && nums[right] <= prior) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] >= prior) {
                left++;
            }
            nums[right] = nums[right];
        }
        nums[left] = prior;
        if (left == k - 1) {
            return left;
        } else if (left < k - 1) {
            // 逆序排
            return quickSorted(nums, k, left + 1, end);
        } else {
            return quickSorted(nums, k, start, left - 1);
        }
    }
}
