/**
 * @author: yangchao
 * @createTime: 2022-07-22  20:56
 * @description: 寻找峰值
 */
public class Test88 {
    public int findPeakElement (int[] nums) {
        // 寻找峰值
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = left + ((right - left) >> 2);  // 使用>>代替/,计算比较快，但是别忘了加括号
            if(nums[mid] > nums[mid+1]){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}
