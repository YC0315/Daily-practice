import java.util.Arrays;

/**
 * @author: yangchao
 * @createTime: 2022-07-15  20:49
 * @description: 重建二叉树：输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 */
public class Test59 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        // 找到根节点
        int rootVal = preorder[0];
        // 找到根节点在中序遍历中的位置，然后划分左右子树
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        // 重建树节点,写一下先序遍历和中序遍历的示意矩阵[根左右]  [左根右]
        TreeNode root = new TreeNode(rootVal);
        // Arrays.copyOfRange(arr, from, to) 包含from，不包含to，递归的根根节点划分左右区间
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1),
                Arrays.copyOfRange(inorder, 0, index));
        root.right = buildTree(Arrays.copyOfRange(preorder, index+1, preorder.length),
                Arrays.copyOfRange(inorder, index+1, inorder.length));
        return root;
    }
}
