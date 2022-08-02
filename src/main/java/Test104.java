import java.util.ArrayList;
import java.util.List;

/**
 * @author: yangchao
 * @createTime: 2022-07-28  20:44
 * @description: 组合总和
 */
public class Test104 {
    /*
        给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使
        数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。
        输入：candidates = [2,3,6,7], target = 7
        输出：[[2,2,3],[7]]
        为了避免搜索过程中的重复方案，我们要去定义一个搜索起点，已经考虑过的数，以后的搜索中就不能出现，
        让我们的每次搜索都从当前起点往后搜索(包含当前起点)，直到搜索到数组末尾。
     **/

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, 0);
        return res;
    }
    public void backtrack(int[] candidates, int target, int index) {
        if(target < 0) return;
        // 结束条件
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        // 做选择,在这一个分支不能使用之前第一次使用的值[1,2,3,4]
        for (int i = index; i < candidates.length; i++) {
            temp.add(candidates[i]);
            // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，
            backtrack(candidates, target - candidates[i], i);
            temp.remove(temp.size() - 1);
        }
    }
}
