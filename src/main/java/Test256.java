import springfox.documentation.service.ApiListing;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yangchao
 * @createTime: 2022-09-08  08:29
 * @description: 组和总和,无重复元素的组合问题
 */
public class Test256 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 组合问题使用回溯
        backTrack(candidates, target, 0);
        return res;
    }

    public void backTrack(int[] candidates, int target, int index) {
        // 结束条件
        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }
        // 做判断
        for(int i = index; i < candidates.length; i++){
            if(target > 0){
                temp.add(candidates[i]);
                backTrack(candidates, target-candidates[i], i);  // 此处是i，因为无重复元素并且没有选取次数限制
                temp.remove(temp.size()-1);
            }
        }
    }
}
