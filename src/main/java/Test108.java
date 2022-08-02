import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yangchao
 * @createTime: 2022-07-29  21:53
 * @description: TODO
 */
public class Test108 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // 对于具有重复元素的问题，一定先排序!!!!!!!
        backtrack(candidates, target, 0);
        return res;
    }

    public void backtrack(int[] candidates, int target, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        // 做选择
        for (int i = index; i < candidates.length; i++) {
            // 在组合总和(无重复元素)的基础上加上判断条件避免重复情况出现!!!
            if (i > index && candidates[i] == candidates[i - 1]) continue;

            if (target - candidates[i] < 0) break;
            temp.add(candidates[i]);
            // 下一轮的起点是i+1
            backtrack(candidates, target - candidates[i], i + 1);
            temp.remove(temp.size() - 1);

        }
    }
}
