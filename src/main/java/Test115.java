import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: yangchao
 * @createTime: 2022-08-01  22:04
 * @description: 找到0~n中缺失的 一个数字，有序数组
 */
public class Test115 {
    // 对于有序数组要首先想到二分查找
    public static int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {  // 有等于号，否则不能取到缺失的数，正好取到缺失的前一个数
            int mid = left + (right - left) / 2;
            if (mid == nums[mid]) {
                left = mid + 1;  // 这块不能跳过
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    // 或者使用hash法,创建一个hashset集合，将元素都添加进去，然后找索引下标
    public static int missingNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int miss = -1;
        // 这块的长度能取到nums.length因为可能是最后一个数缺失!!!!!!
        for (int i = 0; i < nums.length + 1; i++) {
            if (!set.contains(i)) {
                miss = i;
                break;
            }
        }
        return miss;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 3, 4, 5};
        int i = missingNumber1(arr);
        System.out.println(i);
    }
}
