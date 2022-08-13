import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yangchao
 * @createTime: 2022-08-13  08:37
 * @description: 三数之和, 请你找出所有和为 0 且不重复的三元组。‘因为不能重复，所以要先排序后去重！！！！’
 */
public class Test155 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length - 1;
        Arrays.sort(nums);  // 有重复元素，先排序徐
        for (int first = 0; first <= n; first++) {
            // 去重，上一次用过的就不再使用
            if (first > 0 && nums[first] == nums[first - 1]) continue;
            int target = -nums[first];
            int right = n;
            for (int left = first + 1; left < right; left++) {
                // 去重
                if (left > first + 1 && nums[left] == nums[left - 1]) continue;
                // 这块left < right 别忘了，否则找过了！！！！
                while (left < right && nums[left] + nums[right] > target) {  // 没找到
                    right--;
                }
                if (left == right) break;  // 到头了还没找到
                if (nums[left] + nums[right] == target) {  // 找到了
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[first]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    res.add(temp);
                }
            }
        }
        return res;
    }
}
