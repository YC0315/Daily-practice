import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yangchao
 * @createTime: 2022-08-10  08:08
 * @description: 三数之和
 */
public class Test134 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int first = 0; first < n - 2; first++) {
            // 判断重复元素
            if (first > 0 && nums[first] == nums[first - 1]) continue;
            int right = n - 1;
            int target = -nums[first];
            for (int left = first + 1; left < right; left++) {
                // 去重
                if (left > first + 1 && nums[left] == nums[left - 1]) continue;
                while (right > left && nums[left] + nums[right] > target) {
                    right--;
                }
                if(left == right) break;
                if(nums[left] + nums[right] == target){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[first]);temp.add(nums[left]);temp.add(nums[right]);
                    res.add(temp);
                }
            }
        }
        return res;
    }
}
