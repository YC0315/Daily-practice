import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yangchao
 * @createTime: 2022-08-31  14:40
 * @description: 含有重复元素集合的组合
 * 给定一个可能有重复数字的整数数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次，解集不能包含重复的组合。
 */
public class Test224 {
    public static void main(String[] args) {
        int[] c = new int[]{10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> list = combinationSum2(c, target);
        System.out.println(list);
    }
    // 有重复元素的组合问题，用回溯
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> temp = new ArrayList<>();
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 有重复元素先排序
        Arrays.sort(candidates);
        backTrack(candidates, target, 0);
        return res;
    }

    public static void backTrack(int[] candidates, int target, int begin) {
        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(target < 0) return;

        for(int i = begin; i < candidates.length; i++){
            // 去重，因为当前数组已经排序了，如果当前元素和上一个元素相同时就直接跳过
            if(i > begin && candidates[i] == candidates[i-1]) continue;
            if(target - candidates[i] >= 0){
                temp.add(candidates[i]);
                backTrack(candidates, target-candidates[i], i+1);  // i+1保证每个数字只是用一次
                temp.remove(temp.size()-1);
            }
        }
    }
}
