import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: yangchao
 * @createTime: 2022-08-02  21:09
 * @description: 二叉搜索树任意节点的最小距离
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * 差值是一个正数，其数值等于两值之差的绝对值。
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 */
public class Test118 {
    // 因为是二叉搜索树所以可以使用中序遍历排序，返回相邻两节点间的最小值
    List<Integer> res = new ArrayList<>();

    public int minDiffInBST(TreeNode root) {
        // 迭代法
        if (root == null) return Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                // 这些代码在else里面
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        int minValue = Integer.MAX_VALUE;
        for (int i = 1; i < res.size(); i++) {
            // list中的元素通过get(index)方法获取！！！！！！！！！
            int abs = Math.abs(res.get(i) - res.get(i - 1));
            if (abs < minValue) minValue = abs;
        }
        return minValue;
    }

    public int minDiffInBST1(TreeNode root) {
        // 迭代法，入栈出栈，每次检查差值与上一次差值的最小值
        Stack<TreeNode> stack = new Stack<>();
        int pre = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                // 也可以不存列表，每一次出栈，当前节点都与上一个节点做差，并取上一个差的最小值
                root = stack.pop();
                res = Math.min(Math.abs(root.val - pre), res);
                pre = root.val;
                root = root.right;
            }
        }
        return res;
    }
}
