import java.util.ArrayList;
import java.util.List;

/**
 * @author: yangchao
 * @createTime: 2022-08-19  08:22
 * @description: 全排列，不包含重复元素
 */
public class Test182 {
    static List<List<Integer>> res= new ArrayList<>();
    static List<Integer> temp = new ArrayList<>();
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums == null || nums.length == 0) return res;
        findSubList(nums);
        return res;
    }

    public static void findSubList(int[] nums) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!temp.contains(nums[i])) {
                temp.add(nums[i]);
                findSubList(nums);
                temp.remove(temp.size()-1);
            }
        }
    }
}
