/**
 * @author: yangchao
 * @createTime: 2022-07-24  08:16
 * @description: 插入排序:寻找当前元素在前面已经排好序的元素中的位置
 */
public class Test91 {
    public void insertSort(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                int temp = nums[i];
                int j = i;
                while (j > 0 && temp < nums[j - 1]){
                    nums[j] = nums[j-1];
                    j--;
                }
                nums[j] = temp;
            }
        }


    }
}
