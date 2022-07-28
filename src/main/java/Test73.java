import java.util.ArrayList;
import java.util.List;

/**
 * @author: yangchao
 * @createTime: 2022-07-20  09:06
 * @description: 回溯算法
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class Test73 {
    public  static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(res, list, nums);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums) {
        if(list.size() == nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int num : nums) {
            if(!list.contains(num)){
                list.add(num);
                backtrack(res, list, nums);
                list.remove(list.size()-1);
            }
        }
    }
}
