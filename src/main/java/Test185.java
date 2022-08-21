import java.util.ArrayList;
import java.util.List;

/**
 * @author: yangchao
 * @createTime: 2022-08-20  08:40
 * @description: 子集，无重复元素
 */
public class Test185 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums){
        // 可以依次遍历，不断往上一次的结果中添加
        res.add(new ArrayList<>()); // 添加一个空数组到最终集合
        for (int i = 0; i < nums.length; i++) {
            int size = res.size();
            for (int j = 0; j < size; j++) {
                // 从res中取出元素，然后添加，在加入res中去
                List<Integer> temp = new ArrayList<>(res.get(j));
                temp.add(nums[i]);
                res.add(temp);
            }
        }
        return res;
    }

    // 或者使用回溯
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> subsets1(int[] nums){
        backkTrack(nums, 0);
        return res;
    }

    public void backkTrack(int[] nums, int index) {
        res.add(new ArrayList<>(temp));
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            backkTrack(nums, i+1);
            temp.remove(temp.size()-1);
        }

    }
}

