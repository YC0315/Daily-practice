
import java.awt.font.NumericShaper;
import java.util.Arrays;
import java.util.Random;

/**
 * @author: yangchao
 * @createTime: 2022-08-30  15:49
 * @description: 常用的排序算法
 */
public class Test219 {

    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1, 0};
        // quickSort(nums, 0, nums.length - 1);
        split(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    // 使用归并排序
    public static void split(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        split(nums, left, mid);
        split(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    public static void merge(int[] nums, int left, int mid, int right) {
        int l = left;
        int r = mid + 1;  // 这个是右边数组的首节点是mid+1
        int i = 0;
        // 创建一个数组存放临时合并的值
        int[] temp = new int[right - left + 1];
        while (l <= mid && r <= right) {
            temp[i++] = nums[l] < nums[r] ? nums[l++] : nums[r++];
        }
        while (l <= mid) {
            temp[i++] = nums[l++];
        }
        while (r <= right) {
            temp[i++] = nums[right++];
        }
        // 写回原数组，别忘记加left下标偏移
        for (int j = 0; j < temp.length; j++) {
            nums[j + left] = temp[j];
        }
    }


    // 使用快速排序
    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int start = left;
        int end = right;
        // 随机选定基准
        Random random = new Random();
        // 随机选定索引
        int index = random.nextInt(right - left + 1) + left;
        int priori = nums[index];
        nums[index] = nums[left];

        while (left < right) {
            while (left < right && priori <= nums[right]) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && priori >= nums[left]) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = priori;
        quickSort(nums, start, left - 1);
        quickSort(nums, left + 1, end);
    }
}
