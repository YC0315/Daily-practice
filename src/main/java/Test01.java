
import org.junit.Test;

import java.util.Arrays;

public class Test01 {

    @Test
    public void findKthLargest() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 2;
        //使用冒泡排序从高到低进行排序
        maoPaoSort(nums, k);
        int y = nums[nums.length - k];
        System.out.println(y);
    }

    public void maoPaoSort(int[] nums, int target) {
        int temp = 0;
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }


    @Test
    public void findKth() {

        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        //使用冒泡排序从高到低进行排序
        mysort(nums, 0, nums.length - 1);
        int x = nums[nums.length - k];
        System.out.println(Arrays.toString(nums));
        System.out.println(x);
    }

    /**
     * 快速排序：while循环一定要从右边开始！！！！！！！！！
     * @param arrs
     * @param left
     * @param right
     */
    public static void mysort(int[] arrs, int left, int right) {
        if (left >= right) {
            return;
        }
        // 定义一个基准
        int prior = arrs[left];
        int start = left;  // 定义两个变量记录起始位置，方便后面的递归调用
        int end = right;

        while (left < right) {
            // 从右边开始时，条件里包含等号，而且要判断left<right, 外层循环的left<right管不到此处
            while (arrs[right] >= prior && left < right) {
                right -= 1;
                //  去重
                if (arrs[right] == arrs[right + 1]) {
                    right -= 1;
                }
            }
            arrs[left] = arrs[right];
            while (arrs[left] <= prior && left < right) {
                left += 1;
                // 去重
                if(arrs[left] == arrs[left+1]){
                    left++;
                }
            }
            arrs[right] = arrs[left];
        }

        arrs[left] = prior;
        mysort(arrs, start, left - 1);
        mysort(arrs, left + 1, end);
    }
}
