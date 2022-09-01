import java.util.Arrays;

/**
 * @author: yangchao
 * @createTime: 2022-08-31  15:27
 * @description: 移动零，给定一个数组，编写一个函数将所有0移动到数组的末尾，同时保持非零元素的相对位置
 * 原地对数组进行操作
 * 输入： nums = [0, 1, 0, 3, 12]
 * 输出： [1, 3, 12, 0, 0]
 */
public class Test225 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
    }
    public static void moveZeroes1(int[] nums){
        // 使用双指针
        int left = 0;
        int right = left+1;
        while(right < nums.length){
            if(nums[left] == 0 && nums[right] != 0){
                nums[left] = nums[right];
                nums[right] = 0;
            }else if(nums[left] == 0 && nums[right] == 0){
                right++;
                continue;
            }
            left++;
            right++;
        }
    }
    // 也可以这样，想象成两个数组，一直往第二个数组中放，直到遍历结束，剩余位置补0
    public static void moveZeroes(int[] nums){
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[j++] = nums[i];
            }
        }
        while(j < nums.length){
            nums[j++] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }
}
