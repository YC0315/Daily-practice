import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yangchao
 * @createTime: 2022-07-29  21:37
 * @description: 全排列含有重复元素
 */
public class Test107 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] vis = new boolean[nums.length];
        Arrays.sort(nums);  // 一定记得要排序，因为后面检查是否是重复元素就是在数组有序的前提下!!!!!!!!
        backtrack(nums, vis, 0);
        return res;
    }

    public void backtrack(int[] nums, boolean[] vis, int index) {
        // 结束条件
        if (index == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        // 做选择
        int prev = -10;
        for (int i = 0; i < nums.length; i++) {
            // 检查是否用过此元素
            if (prev == nums[i] || vis[i]) continue;

            prev = nums[i];
            temp.add(nums[i]);
            vis[i] = true;
            backtrack(nums, vis, index + 1);
            vis[i] = false;
            temp.remove(temp.size() - 1);
        }

    }
}
