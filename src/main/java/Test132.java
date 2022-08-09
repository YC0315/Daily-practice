/**
 * @author: yangchao
 * @createTime: 2022-08-08  21:39
 * @description: 插入排序
 */
public class Test132 {
    public void insertSort(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] > nums[i]) {
                int temp = nums[i];
                int j = i;
                while (j >= 0 && temp < nums[j - 1]) {
                    nums[j] = nums[j-1];  // 前一个值往后挪
                    j--;
                }
                nums[j] = temp;
            }
        }
    }
}
