import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: yangchao
 * @createTime: 2022-07-10  21:00
 * @description: 二叉树的右视图
 */
public class Test43 {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        // 层序遍历，准备一个队列
        Deque<TreeNode> deque = new LinkedList<>();
        // 准备一个数组存放右视图节点值
        List<Integer> res = new ArrayList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pop();
                if (i == size - 1) {
                    res.add(node.val);
                }
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
            }
        }
        return res;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
