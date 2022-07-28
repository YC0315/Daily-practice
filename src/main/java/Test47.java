/**
 * @author: yangchao
 * @createTime: 2022-07-11  20:22
 * @description: 在二叉树中找到两个节点的最近公共祖先
 */
public class Test47 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 左右节点在不同分支
        if (left != null && right != null) {
            return root;
        }
        // 都在左分支
        if (left != null) {
            return left;
        }
        // 都在右分支
        if (right != null) {
            return right;
        }
        return null;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
