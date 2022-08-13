import java.util.ArrayList;
import java.util.List;

/**
 * @author: yangchao
 * @createTime: 2022-08-13  08:15
 * @description: 组合总和，无重复元素，全排列、组合总和、子集问题要使用回溯，有重复元素时一定要先排序再去重！！
 * 给你一个 '无重复元素' 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 ‘无限制重复被选取’ 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 */
public class Test153 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrace(candidates, target, 0);
        return res;
    }

    public void backtrace(int[] candidates, int target, int index) {
        // 判断结束条件
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        // 无重复元素，因此不用考虑去重问题

        // 做选择,index用来指示，下次递归时，是否还用上一次用过的元素
        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] >= 0) {  // 这块是大于等于0
                temp.add(candidates[i]);
                backtrace(candidates, target - candidates[i], i);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
