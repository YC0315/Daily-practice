import java.util.Arrays;
import java.util.Random;

/**
 * @author: yangchao
 * @createTime: 2022-08-17  08:07
 * @description: 前k个最大的数
 */
public class Test173 {
    public static void main(String[] args) {
        int[] nums = {2,1,3};
        int k = 2;
        int[] thK = findThK(nums, k);
        System.out.println(Arrays.toString(thK));
    }
    public static int[] findThK(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];
        int index = quickSort(nums, 0, nums.length - 1, k);
        return Arrays.copyOfRange(nums, 0, index + 1);
    }

    public static int quickSort(int[] nums, int left, int right, int k) {
        int start = left;
        int end = right;
        // 选定基准
        Random random = new Random();
        int indx = random.nextInt(right - left + 1) + left;
        int prior = nums[indx];
        nums[indx] = nums[left];

        while (left < right) {
            while (left < right && prior <= nums[right]) right--;
            nums[left] = nums[right];
            while (left < right && prior >= nums[left]) left++;
            nums[right] = nums[left];
        }
        nums[left] = prior;
        if (left < k - 1) {
            return quickSort(nums, left + 1, end, k);
        } else if (left > k - 1) {
            return quickSort(nums, start, left - 1, k);
        } else {
            return left;
        }
    }
}
