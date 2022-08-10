/**
 * @author: yangchao
 * @createTime: 2022-08-10  08:05
 * @description: 插入排序
 */
public class Test133 {
    public void insertSort(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                int temp = nums[i];
                int j = i;
                while (j >= 0 && temp < nums[j - 1]) {
                    nums[j] = nums[j-1];
                    j--;
                }
                nums[j] = temp;
            }
        }
    }
}
