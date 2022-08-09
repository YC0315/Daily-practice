import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yangchao
 * @createTime: 2022-08-08  21:39
 * @description: 三数之和
 */
public class Test131 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums); // 不要忘记先排序，否则排除重复元素的步骤无效！！
        for (int first = 0; first < n - 2; first++) {
            // 首先排除重复元素
            if (first > 0 && nums[first] == nums[first - 1]) continue;
            // 使用双指针判断
            int right = n - 1;
            int target = -nums[first];
            for (int left = first + 1; left < right; left++) {
                // 排除重复元素
                if (left > first + 1 && nums[left] == nums[left - 1]) continue;
                // 这块在移动右指针时，要判断和左指针的位置关系！！！
                // 这块只需要判断右指针，因为头节点和左指针已经用两层for循环去移动了
                while (left < right && nums[left] + nums[right] > target) {
                    right--;
                }
                if (left == right) break;
                if (nums[left] + nums[right] == target) {
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
