import java.util.ArrayList;
import java.util.List;

/**
 * 回溯算法
 */
public class Test09 {
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null) {
            return res;
        }
        // 回溯
        backtrack(candidates, target, 0);
        return res;
    }

    public static void backtrack(int[] candidates, int target, int index) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));// 也就是将传入的参数(path列表)复制一份!!
        }
        for (int start = index; start < candidates.length; start++) {
            path.add(candidates[start]);
            //System.out.println("递归之前 => " + path + "，剩余 = " + (target - candidates[start]));
            backtrack(candidates, target - candidates[start], start);
            path.remove(path.size() - 1);
            //System.out.println("递归之后 => " + path);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6};
        int target = 6;
        List<List<Integer>> list = combinationSum(arr, target);
        System.out.println(list);

    }


}
