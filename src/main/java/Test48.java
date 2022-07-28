import java.util.ArrayList;
import java.util.List;

/**
 * @author: yangchao
 * @createTime: 2022-07-11  21:02
 * @description: 验证二叉搜索树
 */
public class Test48 {
    // 二叉搜索树的中序遍历为升序！！
    List<Integer> list = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }
        inorder(root);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            if (list.get(i - 1) > list.get(i)) {
                return false;
            }
        }
        return true;
    }
    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    public class TreeNode {
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
