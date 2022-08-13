import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yangchao
 * @createTime: 2022-08-13  08:23
 * @description: 组合总和，有重复元素
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * !!因为有重复元素，因此要先排序再考虑去重的问题，并且每个数字在每个组合中只能用一次，索引i来记录还用不用上一次的元素
 * 注意：解集不能包含重复的组合。
 * candidates = [10,1,2,7,6,1,5], target = 8,
 */
public class Test154 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 只要有重复元素一定要先排序
        Arrays.sort(candidates);
        backTrack(candidates, target, 0); // i记录下一次递归是否还用上一次的元素
        return res;
    }

    public void backTrack(int[] candidates, int target, int index) {
        // 判断是否满足结束条件
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        // 做判断
        for (int i = index; i < candidates.length; i++) {
            // 因为有重复元素，所以要考虑去重,如果在当前递归 层次用过这个元素，则跳过
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            if (target - candidates[i] >= 0) {
                temp.add(candidates[i]);
                backTrack(candidates, target - candidates[i], i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
