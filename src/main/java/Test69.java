import java.util.ArrayList;
import java.util.List;

/**
 * @author: yangchao
 * @createTime: 2022-07-19  20:12
 * @description: 不含重复元素的全排列，全排列问题要使用回溯算法
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class Test69 {
    public static void main(String[] args) {
        int[] num = {1,2,3};
        List<List<Integer>> permute = permute(num);
        System.out.println(permute);
    }
    public  static List<List<Integer>> permute(int[] nums) {
        // 路径
        List<List<Integer>> res = new ArrayList<>();
        // 选择列表
        List<Integer> list = new ArrayList<>();
        backtrack(res, list, nums);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            // 因为list是被反复利用的一个参数，会一直变化，new一个新的list相当于copy，这样才不会影响结果集中元素
            // 这块要记住重新拷贝一份，不要直接将list添加到res
            res.add(new ArrayList<Integer>(list));
            // res.add(list);  这里如果直接将list填入res，实际填入的是list的地址引用，list的内容又在变化，因此不可以
            return;
        }
        for (int num : nums) {
            if (!list.contains(num)) {
                list.add(num);
                backtrack(res, list, nums);
                list.remove(list.size() - 1);
            }
        }
    }
}
