import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yangchao
 * @createTime: 2022-09-08  08:36
 * @description: 有重复元素的组合总和问题
 */
public class Test257 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 有重复元素，排序
        Arrays.sort(candidates);
        backTrack(candidates, target, 0);
        return res;
    }

    public void backTrack(int[] candidates, int target, int index) {
        // 结束条件
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        // 做选择
        for (int i = index; i < candidates.length; i++) {
            // 先去重
            if (i > index && candidates[i] == candidates[i - 1]) continue;  // 这块要i>index因为i是从index开始的
            if (target-candidates[i] >= 0) {  // 这块是target-candidates[i] >= 0，这块要有等于0，否则不能进入结束条件
                temp.add(candidates[i]);
                backTrack(candidates, target - candidates[i], i + 1);  // 因为每个元素只能选取一次，所以这块是i+1
                temp.remove(temp.size() - 1);
            }
        }
    }
}
