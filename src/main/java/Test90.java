import java.text.NumberFormat;
import java.util.Arrays;

/**
 * @author: yangchao
 * @createTime: 2022-07-23  19:01
 * @description: 归并排序,是稳定性排序,时间复杂度都是O(nlogn), 空间复杂度是O(n)
 * 归并排序总时间=分解时间+子序列排好序时间+合并时间
 * 无论每个序列有多少数都是折中分解，所以分解时间是个常数，可以忽略不计。
 * 则：归并排序总时间 = 子序列排好序时间 + 合并时间
 * 由于合并时，两个子序列已经组内排好序了，if循环中有n个数需要比较，所以时间复杂度为n。
 * 子序列排序时间为O(logn)
 */
public class Test90 {
    public static void main(String[] args) {
        int[] nums = {2, 5, 7, 0, 1, 4};
        mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
    // 拆分数组
    private static void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = left + ((right - left) >> 2);
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }
    // 合并数组
    private static void merge(int[] nums, int left, int mid, int right) {
        int leftStart = left;
        int rightStart = mid + 1;  // 右边数组开始的位置
        int[] temp = new int[right - left + 1];
        int index = 0;
        while (leftStart <= mid && rightStart <= right) {
            temp[index++] = nums[leftStart] < nums[rightStart] ? nums[leftStart++] : nums[rightStart++];
        }
        while (leftStart <= mid) {
            temp[index++] = nums[leftStart++];
        }
        while (rightStart <= right) {
            temp[index++] = nums[rightStart++];
        }
        // 将临时数组分别复制到原数组的每块区域上去
        for (int i = 0; i < temp.length; i++) {
            nums[i + left] = temp[i];  // 为什么要加left，因为temp只是nums的一部分数组
        }
    }
}

