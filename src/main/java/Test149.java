import java.util.ArrayList;
import java.util.List;

/**
 * @author: yangchao
 * @createTime: 2022-08-12  19:41
 * @description: 组合总和，无重复元素
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 ‘无限制重复被选取’ 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 */
public class Test149 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTrack(candidates, target, 0);
        return res;
    }
    // index要指明最上层遍历到了哪个元素
    public void backTrack(int[] candidates, int target, int index) {
        // 判断结束条件
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        // 做选择
        /*
         for循环的作用在于另寻他路： 你可以用for循环可以实现一个路径选择器的功能，
         该路径选择器可以逐个选择当前节点下的所有可能往下走下去的分支路径。 例如：
         现在你走到了节点a，a就像个十字路口，你从上面来到达了a，可以继续向下走。若此时向下走的路有i条，
         那么你肯定要逐个的把这i条都试一遍才行。
         而for的作用就是可以让你逐个把所有向下的i个路径既不重复，也不缺失的都试一遍

          递归可以实现一条路走到黑和回退一步： 一条路走到黑： 递归意味着继续向着for给出的路径向下走一步。
          如果我们把递归放在for循环内部，那么for每一次的循环，都在给出一个路径之后，进入递归，也就继续向下走了。
          直到递归出口（走无可走）为止。那么这就是一条路走到黑的实现方法。 递归从递归出口出来之后，就会实现回退一步。
          这也是为什么for循环每次要从i=index开始
         **/
        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] >= 0) {
                temp.add(candidates[i]);
                // 向下继续走,沿着i索引元素这条道一条道走到黑，所以这里传递的还是i，i元素要重复利用
                backTrack(candidates, target - candidates[i], i);
                temp.remove(temp.size() - 1); // 回朔清理。当前节点下的所有情况都进行完了，该节点也不应该在path里面了。
            }
        }
    }
}
