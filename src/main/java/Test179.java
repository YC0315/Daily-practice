/**
 * @author: yangchao
 * @createTime: 2022-08-18  15:39
 * @description: 判断对称二叉树
 */
public class Test179 {
    public boolean isSymmetric(TreeNode root) {
        // 使用递归
        if (root == null) return true;
        return dfs(root.left, root.right);
    }
    public boolean dfs(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true; // 如果到达叶节点
        if(left == null || right == null) return false; // 左右子树不同时存在
        // 递归到下一层时，判断左子树左子节点和右子树的右子节点，以及左子树的右子节点和右子树的左子节点是否相等
        return left.val == right.val && dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}
