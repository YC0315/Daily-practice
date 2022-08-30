/**
 * @author: yangchao
 * @createTime: 2022-08-29  20:49
 * @description: 二叉树的直径（就相当于二叉树的最长路径）
 */
public class Test214 {
    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return res;
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 0;
        }
        int leftSize = root.left == null ? 0 : dfs(root.left) + 1;
        int rightSize = root.right == null ? 0 : dfs(root.right) + 1;
        res = Math.max(res, leftSize + rightSize);  // leftSize + rightSize是过根节点的长度，res是不一定过根节点的长度
        return Math.max(leftSize, rightSize); // 返回以该节点为根的子树的最长深度！！！

    }
}
