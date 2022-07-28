import java.util.ArrayList;
import java.util.List;

/**
 * @author: yangchao
 * @createTime: 2022-07-19  22:03
 * @description: 组合总和，组合问题排列问题都使用回溯算法
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 */
public class Test70 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(candidates, target, res, list);
        return res;
    }

    private void backtrack(int[] candidates, int target, List<List<Integer>> res, List<Integer> list) {

    }
}
