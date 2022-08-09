import java.util.Arrays;

/**
 * @author: yangchao
 * @createTime: 2022-08-08  19:15
 * @description: 插入排序
 */
public class Test129 {
    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 7, 5};
        insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    // 寻找当前元素在已排好序的元素集合中的位置
    public static void insertSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                int temp = nums[i];
                int j = i;
                // 这块使用while循环，往前寻找插入点，
                while (j > 0 && temp < nums[j - 1]) {
                    nums[j] = nums[j - 1];
                    j--;
                }
                // 找到插入点后，将当前元素插入
                nums[j] = temp;
            }
        }
    }
}
