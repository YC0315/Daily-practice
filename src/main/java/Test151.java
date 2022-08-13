import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: yangchao
 * @createTime: 2022-08-12  22:14
 * @description: 二叉树最底层最左边的值
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * <p>
 * 假设二叉树中至少有一个节点。
 */
public class Test151 {
    // 基于队列实现层序遍历
    public int findBottomLeftValue(TreeNode root) {
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(i == 0) res = node.val; // 第一次加入时保存值
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
        return res;
    }
}
