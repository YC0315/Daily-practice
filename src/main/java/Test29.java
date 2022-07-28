import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: yangchao
 * @createTime: 2022-06-28  20:45
 * @description: 统计二叉树的最大深度
 */
public class Test29 {
    // 使用层序遍历方法BFS
    public int maxDepth(TreeNode root) {
        // 二叉树最长路径
        int count = 0;
        if (root == null) {
            return count;
        }
        // 使用二叉树的层序遍历
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {   // 要使用这种方式判断队列是否为空！！！
            count++;
            int length = deque.size();  // 统计队列的长度要在for循环外面统计，否则每次循环，队列的长度会变
            for (int i = 0; i < length; i++) {
                TreeNode node = deque.pop();
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
            }
        }
        return count;
    }

    // 自底向上使用深度遍历方法DFS
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    // 自顶向下使用深度遍历方法DFS
    int res = 0;

    public int maxDepth2(TreeNode root) {
        dfs(root, 1);
        return res;
    }

    private void dfs(TreeNode root, int height) {
        if (root == null) {
            return;
        }
        if(root.left == null && root.right == null){
            res =  Math.max(res, height);
        }
        dfs(root.left, height + 1);
        dfs(root.right, height + 1);
    }
}
