import java.util.Arrays;

/**
 * 在排序序列中寻找第一个和对后一个值
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 */
public class Test02 {
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        int left = 0, right = nums.length-1;
        boolean flag1=false,flag2=false;
        /*if(nums.length<=1){
            result[0] = -1;
            result[1] = -1;
            return result;
        }*/

        while(left <= right){
            if(nums[left] == target){
                result[0] = left;
                flag1=true;
                break;
            }
            left++;
        }
        while(left <= right){
            if(nums[right] == target){
                result[1] = right;
                flag2=true;
                break;
            }
            right--;
        }
        if(!flag1) result[0] = -1;
        if(!flag2) result[1] = -1;

        return result;
    }

    public static void main(String[] args) {
        //int[] nums = {5,7,7,8,8,10};
        int[] nums = {1};
        int target = 1;
        int[] res = searchRange(nums, target);
        System.out.println(Arrays.toString(res));
    }

}
