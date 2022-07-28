import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yangchao
 * @createTime: 2022-07-28  08:09
 * @description: TODO
 */
public class Test100 {
    // 全排列 包含重复数字，结果不包含重复元素
    //输入：nums = [1,2,3]
    //输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) return res;
        List<Integer> temp = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        Arrays.sort(nums); // 记得排序，否则相邻元素不会靠在一起
        backtracking(nums, temp, vis, 0);
        return res;
    }

    public void backtracking(int[] nums, List<Integer> temp, boolean[] vis, int index) {
        // 结束标志
        if (index == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        // 做选择
        int prev = -11;
        for (int i = 0; i < nums.length; i++) {
            if (prev == nums[i] || vis[i]) continue;  // 这块是continue跳过这次选择而不是直接返回!!!!!

            prev = nums[i];
            temp.add(nums[i]);
            vis[i] = true;
            backtracking(nums, temp, vis, index + 1);
            vis[i] = false;
            temp.remove(temp.size() - 1);
        }
    }

    // 输入一个字符串，打印出该字符串中字符的所有排列，里面不能有重复元素。
    // 输入：s = "abc"
    // 输出：["abc","acb","bac","bca","cab","cba"]
    List<String> res1 = new ArrayList<>();

    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        // 动态临时字符串
        StringBuilder temp = new StringBuilder();
        Arrays.sort(chars);  // 排序，聚合相同元素
        boolean[] vis = new boolean[chars.length];
        backtrack(chars, temp, vis, 0);
        String[] result = new String[res1.size()];
        return res1.toArray(result);  // List转数组
    }

    public void backtrack(char[] chars, StringBuilder temp, boolean[] vis, int index) {
        // 结束标志
        if (index == chars.length) {
            res1.add(temp.toString());
            return;
        }
        // 做选择
        int prev = -1;
        for (int i = 0; i < chars.length; i++) {
            if (prev == chars[i] || vis[i]) continue;
            prev = chars[i];
            temp.append(chars[i]);
            vis[i] = true;
            backtrack(chars, temp, vis, index + 1);
            vis[i] = false;
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    // 生成有效匹配的括号
    // 正整数 n 代表生成括号的对数，请设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
    // 输入：n = 3
    // 输出：["((()))","(()())","(())()","()(())","()()()"]
    List<String> res2 = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        // 动态临时字符串
        StringBuilder temp = new StringBuilder();
        backtrace(temp, n, n);
        return res2;

    }
    public void backtrace(StringBuilder temp, int left, int right) {
        if (left == 0 && right == 0) {
            res2.add(temp.toString());
            return;
        }

        if (left > 0) {
            temp.append('(');
            backtrace(temp, left - 1, right);
            temp.deleteCharAt(temp.length() - 1);
        }
        if (right > left) {
            temp.append(')');
            backtrace(temp, left, right - 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
