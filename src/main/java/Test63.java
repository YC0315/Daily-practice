import java.util.Arrays;

/**
 * @author: yangchao
 * @createTime: 2022-07-17  20:41
 * @description: 搜索旋转排序数组,但是数组中有重复元素！！
 * 输入：nums = [2,5,6,0,0,1,2], target = 0
 * 输出：true
 */
public class Test63 {
    public boolean search(int[] nums, int target) {
        // 搜索数组，就要想到二分查找
        if (nums.length == 0) return false;
        if (nums.length == 1) return nums[0] == target;
        int left = 0;
        int right = nums.length - 1;
        // 使用二分查找时这块有等号！！
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            // 对于数组中有重复元素的情况，二分查找时可能会有 a[l]=a[mid]=a[r]，此时无法判断区间 [l,mid] 和区间[mid+1,r] 哪个是有序的。
            // 对于这种情况，我们只能将当前二分区间的左边界加一，右边界减一，然后在新区间上继续二分查找
            // 对于有重复元素的情况记住下面这种解法
            if(nums[left] == nums[mid] && nums[mid] == nums[right]){
                right--;
                left++;
            }else if (nums[mid] <= nums[right]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (target >= nums[0] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }
}