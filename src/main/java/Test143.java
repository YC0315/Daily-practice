import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author: yangchao
 * @createTime: 2022-08-11  19:24
 * @description: 二叉树的最大深度
 */
public class Test143 {
    // 层序遍历使用的是队列！！！不是栈
    public int maxDepth(TreeNode root) {
        int res = 0;
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            res++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return res;
    }

    // 也可以使用递归
    public int maxDepth1(TreeNode root) {
        // 递归出口
        if(root == null) return 0;
        // dfs，先递归左子结点，再递归右子结点，最后求出每一子树的深度的最大值
        return Math.max(maxDepth1(root.left), maxDepth1(root.right)) + 1;
    }
}
