import java.util.ArrayList;
import java.util.List;

/**
 * @author: yangchao
 * @createTime: 2022-08-19  08:37
 * @description: 子集，不包含重复元素
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class Test183 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        // 遍历
        int n = nums.length;
        res.add(new ArrayList<>()); // 别忘了加入一个空的列表
        for (int i = 0; i < n; i++) {
            int m = res.size();
            for (int j = 0; j < m; j++) {
                List<Integer> temp = new ArrayList<>(res.get(j));
                temp.add(nums[i]);
                res.add(new ArrayList<>(temp));
            }
        }
        return res;
    }

    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> subsets1(int[] nums) {
        // 使用回溯
        backtrace(nums, 0);
        return res;
    }

    public void backtrace(int[] nums, int start) {
        // 子集问题，path的收集是无条件的
        res.add(new ArrayList<>(temp));
        // 做选择
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrace(nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }


}
