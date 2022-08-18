import java.util.ArrayList;
import java.util.List;

/**
 * @author: yangchao
 * @createTime: 2022-08-17  16:30
 * @description: 全排列
 * 给定一个’不含重复数字‘的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class Test175 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }
    // 全排列使用回溯算法
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> temp = new ArrayList<>();
    public static List<List<Integer>> permute(int[] nums) {
        brackTrace(nums);
        return res;
    }

    public static void brackTrace(int[] nums) {
        // 判断结束条件
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        // 做选择
        for (int num : nums) {
            if(!temp.contains(num)){
                temp.add(num);
                brackTrace(nums);
                temp.remove(temp.size()-1);
            }
        }
    }
}
