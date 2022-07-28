/**
 * @author: yangchao
 * @createTime: 2022-07-04  20:31
 * @description: 153:寻找旋转排序数组中的最小值
 * (只要是有序数组哪怕是部分有序，而且时间复杂度要求是O(logn)，就是用二分法)
 */
public class Test35 {
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        int min = findMin(nums);
        System.out.println(min);
    }

    // 时间复杂度O(logn)
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            // 二分查找，每一次都找无序的那一半，找到最后的中间值就是最小值
            if (nums[mid] < nums[right]) {
                right = mid;  // 此处不能+1，因为mid有可能是最小值
            } else {
                left = mid + 1;  // 此处要+1，因为mid不可能是最小值
            }
        }
        return nums[mid];
    }
}
