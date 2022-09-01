import java.util.Arrays;

/**
 * @author: yangchao
 * @createTime: 2022-08-31  14:03
 * @description: 插入排序
 */
public class Test223 {
    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1, 0};
        insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void insertSort(int[] nums) {
        if (nums.length <= 1) return;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                int temp = nums[i];
                int index = i;
                // 这里使用while循环，可以随时退出循环，如果使用for循环的话，不方便确定循环结束的终点，要一直循环到头才结束。
                while (index > 0 && nums[index - 1] > temp) {
                    nums[index] = nums[index - 1];
                    index--;
                }
                nums[index] = temp;
            }
        }
    }
}
