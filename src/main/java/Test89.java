import java.util.Arrays;

/**
 * @author: yangchao
 * @createTime: 2022-07-22  21:35
 * @description: 数组中的逆序对
 */
public class Test89 {
    // 可以使用归并排序的思想
    int sum = 0;
    public int reversePairs(int[] nums) {
        if (nums.length < 2) return 0;
        mergeSort(nums);
        return sum;
    }

    private int[] mergeSort(int[] nums) {
        if (nums.length < 2) return nums;
        int mid = nums.length >> 2;
        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid, nums.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    private int[] merge(int[] left, int[] right) {
        int[] arr = new int[right.length - left.length + 1];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if(left[0] < right[0]){
                arr[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            }else{
                sum += left.length - i;
                arr[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }
        while (left.length>0) {
            arr[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }
        while (right.length > 0) {
            arr[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }
        return arr;
    }

}
