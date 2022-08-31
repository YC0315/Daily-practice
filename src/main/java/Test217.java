/**
 * @author: yangchao
 * @createTime: 2022-08-30  09:04
 * @description: 二叉树的直径
 */
public class Test217 {
    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return res;
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root.left == null && root.right == null) return 0;
        int leftSize = root.left == null ? 0 : dfs(root.left) + 1;
        int rightSize = root.right == null ? 0 : dfs(root.right) + 1;
        // 返回左子树，右子树，左子树+右子树的最大长度，leftSize+rightSize不一定是过根节点的长度，也可能是左子树或者右子树上的长度
        res = Math.max(res, leftSize + rightSize);
        // 返回以该节点为根的最大的子树的深度
        return Math.max(leftSize, rightSize);
    }
}
