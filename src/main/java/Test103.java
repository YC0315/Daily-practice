import java.util.*;

/**
 * @author: yangchao
 * @createTime: 2022-07-28  19:37
 * @description: 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class Test103 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList<>());
        for(int i = 0; i < nums.length; i++){
            // 取出res中得每一个[],添加新的元素进去，同时将temp添加到res
            int inner = res.size();
            for(int j = 0; j < inner; j++){
                // 依次取出res中的每个[]
                List<Integer> temp = new ArrayList<>(res.get(j));
                temp.add(nums[i]);
                res.add(temp);
            }
        }
        return res;
    }


    // 子集||
    // 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
    // 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
    // 输入：nums = [1,2,2]
    // 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
    List<List<Integer>> res1 = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res.add(new ArrayList<>());
        for(int i = 0; i < nums.length; i++){
            // 取出res中得每一个[],添加新的元素进去，同时将temp添加到res
            int inner = res1.size();
            for(int j = 0; j < inner; j++){
                // 依次取出res中的每个[]
                List<Integer> temp = new ArrayList<>(res.get(j));
                temp.add(nums[i]);
                Collections.sort(temp);  // 为了保证res中没有重复的子集，需要对temp列表进行排序，然后再放入res
                if(!res1.contains(temp)){
                    res1.add(temp);
                }
            }
        }
        return res;
    }



}
