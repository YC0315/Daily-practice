import java.util.*;

/**
 * @author: yangchao
 * @createTime: 2022-07-26  21:00
 * @description: 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 *  含有重复元素的字符串的排列和含有重复元素的数组排列是一类题！！
 */
public class Test95 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> list = permuteUnique(nums);
        System.out.println(list);
    }
    // 可以使用回溯加记录的方式
    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> permuteUnique(int[] nums) {
        if(nums == null || nums.length == 0) return res;

        // 创建临时数组
        List<Integer> temp = new ArrayList<>();
        // 创建Map来检查当前元素是否已经用过<索引，元素值>
        Map<Integer, Integer> map = new HashMap<>();
        backtrack(nums, temp, map);
        return res;
    }

    public static void backtrack(int[] nums, List<Integer> temp, Map<Integer, Integer> map) {
        // 结束回溯条件
        if(temp.size() == nums.length){
            if(!res.contains(temp)){
                res.add(new ArrayList<>(temp));  // 这块一定记住要拷贝一份添加，因为temp一直在变
                                                 // 直接添加的话添加的是地址
            }
            return;
        }

        // 做选择
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(i)){
                continue;
            }
            // 选择
            temp.add(nums[i]);
            map.put(i, nums[i]);
            // 回溯
            backtrack(nums, temp, map);
            // 撤销最后一次选择
            temp.remove(temp.size()-1);
            map.remove(i);
        }
    }


    // 也可以使用无重复元素的全排列的方式，只不过需要加一个额外的重复元素的判断
    List<List<Integer>> res1 = new ArrayList<>();
    public List<List<Integer>> permuteUnique1(int[] nums) {
        if(nums == null || nums.length == 0) return res;
        // 创建临时数组
        List<Integer> temp = new ArrayList<>();
        // 对数组进行排序，这样是为了更好的找到重复元素
        Arrays.sort(nums);
        // 创建一个标记数组，标记元素是否已经使用过
        boolean[] vis = new boolean[nums.length];
        backtrace(nums, temp, vis, 0);
        return res1;
    }
    // index是指现在填入的元素在temp中的下标
    private void backtrace(int[] nums, List<Integer> temp, boolean[] vis, int index) {
        // 结束选择
        if(index == nums.length){
            res1.add(new ArrayList<>(temp));
            return;
        }
        // 做选择
        // 定义一个变量，来区分当前元素是否已经遍历过了
        int prev = -11;
        for (int i = 0; i < nums.length; i++) {
            if(vis[i] || prev == nums[i]) continue;  // 假如当前元素遍历过了，或者没有遍历过，但是是重复元素

            prev = nums[i];  // 标记当前元素
            temp.add(nums[i]);
            vis[i] = true;  // 标识当前元素已经遍历过了
            backtrace(nums, temp, vis, index+1);  // index要加1，否则temp永远不满
            vis[i] = false; // 撤销选择
            temp.remove(temp.size()-1);
        }
    }
}
