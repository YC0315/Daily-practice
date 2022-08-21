
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: yangchao
 * @createTime: 2022-08-21  08:57
 * @description: 二叉树的遍历，迭代方法，先序-中序-后序
 */
public class Test186 {
    List<Integer> res = new ArrayList<>();

    public List<Integer> preTraversal(TreeNode root) {
        if (root == null) return res;
        // 迭代法要显示的维护一个栈
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return res;
    }

    // 中序遍历
    List<Integer> res1 = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return res;
        // 显示的维护一个栈
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root.left);
                root = root.left;
            } else {
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }

    // 后序遍历：左-右-根
    List<Integer> res2 = new ArrayList<>();
    public List<Integer> postTraversal(TreeNode root) {
        // 显示的维护一个栈
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode prev = null; // prev变量用来标记右子树有没有遍历过
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            // 假如右子树遍历过了，或者没有右子树
            if (curr.right == null || prev == curr.right) {
                res.add(curr.val);
                prev = curr;
                curr = null;
            } else {
                // 右子树没有遍历过，先去遍历右子树
                stack.push(curr);
                curr = curr.right;
            }
        }
        return res2;
    }
}
