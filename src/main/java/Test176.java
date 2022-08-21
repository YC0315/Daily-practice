import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yangchao
 * @createTime: 2022-08-17  19:03
 * @description: 全排列||
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列
 * 输入：nums = [1,1,2]
 * 输出：[[1,1,2],[1,2,1],[2,1,1]]
 */
public class Test176 {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(permuteUnique(nums));
    }
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> temp = new ArrayList<>();
    public static List<List<Integer>> permuteUnique(int[] nums) {
        if(nums == null || nums.length == 0) return res;
        // 含有重复元素，先排序再去重
        Arrays.sort(nums);
        // 创建一个数组用于标示当前元素是否使用过
        int[] vis = new int[nums.length];
        backtrack(nums, vis, 0);
        return res;
    }

    public static void backtrack(int[] nums, int[] vis, int index) {
        // 判断结束条件
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        // 去重
        int prev = -11;  // 标识当前元素和上一个元素是否相同，相同直接跳过，否则会有大量重复
        for (int i = 0; i < nums.length; i++) {
            if(prev == nums[i] || vis[i] == 1) continue; // 当前元素没有用过，并且当前元素和上一个元素不相同

            // 做选择
            prev = nums[i];
            temp.add(nums[i]);
            vis[i] = 1;
            backtrack(nums, vis, index+1);
            vis[i]= 0;
            temp.remove(temp.size()-1);
        }
    }
}
