/**
 * @author: yangchao
 * @createTime: 2022-08-01  22:04
 * @description: 找到0~n中缺失的 一个数字，有序数组
 */
public class Test115 {
    // 对于有序数组要首先想到二分查找
    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 当前索引不等于元素值，则一定在左边数组确实
            if(mid != nums[mid]){
                right = mid;  // 这块不能跳过
            }else{
                left = mid;
            }
        }
        return 0;

    }
}
