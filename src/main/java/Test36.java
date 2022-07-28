import java.util.Arrays;

/**
 * @author: yangchao
 * @createTime: 2022-07-04  21:49
 * @description: 852. 山脉数组的峰顶索引
 */
public class Test36 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 3};
        int index = peakIndexInMountainArray(nums);
        System.out.println(index);
//        int[] arr1 = Arrays.copyOfRange(nums, 4, 5);// 截取一个int数组的一部分
    }

    public static int peakIndexInMountainArray(int[] arr) {
        // 对于有序数组首先想到二分法
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (left < right) {
            mid = left + ((right - left) / 2);
            if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
                return mid;
            } else if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else if (arr[mid] > arr[mid + 1]) {
                right = mid;
            }
        }
        return mid;
    }
}
