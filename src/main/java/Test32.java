import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: yangchao
 * @createTime: 2022-07-01  20:35
 * @description: 搜索旋转排序数组：思路：如果中间的数小于最右边的数，则右半段是有序的，
 * 若中间数大于最右边数，则左半段是有序的，我们只要在有序的半段里用首尾两个数组来判断目标值是否在这一区域内，这样就可以确定保留哪半边了
 */
public class Test32 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,1};
        int target = 1;
        int search = search1(nums, target);
        System.out.println(search);
    }

    public static int search(int[] nums, int target) {
        int flag = -1;
        // 自动装箱将整形数组转变成包装类型数组
        Integer[] array = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, array);
        if (list.contains(target)) {
            flag = list.indexOf(target);
        }
        return flag;
    }

    // 时间复杂度O(logn)
    // 方法二：将数组一分为二，先判断哪边有序，然后判断target是否在有序的那边，然后缩小查找的范围
    public static int search1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < nums[right]) {  // 判断左边有序还是右边有序，然后在有序的那一边再判断是否包含target
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
        }
        return -1;
    }


    // 二分查找
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        if (left > right) {
            return -1;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target > arr[mid]) {
                right = mid - 1;
            } else if (target < arr[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
