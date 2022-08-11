import java.util.Random;

/**
 * @author: yangchao
 * @createTime: 2022-08-10  20:25
 * @description: 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 */
public class Test139 {
    public static void main(String[] args) {
        int[] nums = {2, 1};
        int k = 2;
        int kthLargest = findKthLargest(nums, k);
        System.out.println(kthLargest);
    }
    static Random random = new Random();
    public static int findKthLargest(int[] nums, int k) {
        return mysort(nums, 0, nums.length - 1, k);
    }
    public static int mysort(int[] nums, int left, int right, int k) {
        // 快排，如果当前元素的索引等于n-k则返回
        int start = left;
        int end = right;
//        int prior = nums[left];
        // 随机选定基准
        int index = random.nextInt(right-left+1)+left;
        int prior = nums[index];
        nums[index] = nums[left];

        while (left < right) {
            // 逆序排，比基准大的放左边
            while (prior >= nums[right] && left < right) {
                right--;
            }
            nums[left] = nums[right];
            // 逆序排，比基准小的放右边
            while (prior <= nums[left] && left < right) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = prior;
        if (left == k - 1) { // 逆序时，k-1索引元素就是第K大的元素
            return nums[left];
        } else if (left > k - 1) {
            // 如果当前分界点的索引大于要找的元素的索引，则递归左半区间，右半区间扔掉
            return mysort(nums, start, left - 1, k);
        } else {
            // 否则递归右半区间
            return mysort(nums, left + 1, end, k);
        }
    }
}
