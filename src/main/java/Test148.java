import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yangchao
 * @createTime: 2022-08-12  18:59
 * @description: 组合总和，有重复元素
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * 注意：解集不能包含重复的组合。
 * candidates = [10,1,2,7,6,1,5], target = 8,
 */
public class Test148 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);  // 只要有重复元素就先进行排序
        backTrack(candidates, target, 0);
        return res;
    }

    public void backTrack(int[] candidates, int target, int index) {
        // 判断是否满足条件，
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        // 做选择，不可以从0开始取，从0开始取会导致每个组合中都有重复值
        for (int i = index; i < candidates.length; i++) {
            // 只要有重复元素就要想到去重的问题，保证本层不重复，但不同层可以重复
            if (i > index && candidates[i] == candidates[i - 1]) continue;

            // 只要target还没减到0就 一直进行
            if (target - candidates[i] >= 0) {
                temp.add(candidates[i]);
                // 因为一个数只能用一次，因此下次循环要从第i+1个元素开始
                // 向下继续走,沿着i索引元素这条道一条道走到黑，因为一个元素只能使用一次，所以这里不能再使用i了！！！！
                backTrack(candidates, target - candidates[i], i+1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
