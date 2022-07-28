import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: yangchao
 * @createTime: 2022-07-10  19:50
 * @description: 重建二叉树：输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 前序遍历列表：第一个元素永远是 [根节点 (root)]
 * 中序遍历列表：根节点 (root)[左边]的所有元素都在根节点的[左分支]，[右边]的所有元素都在根节点的[右分支]
 * 算法思路：
 * 通过[前序遍历列表]确定[根节点 (root)]
 * 将[中序遍历列表]的节点分割成[左分支节点]和[右分支节点]
 * 递归寻找[左分支节点]中的[根节点 (left child)]和 [右分支节点]中的[根节点 (right child)]
 */
public class Test42 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        int rootValue = preorder[0]; // 先序遍历第一个元素肯定是树的根节点
        // 寻找树的根节点在中序遍历中的位置以区分左右子树
        int rootIndex = 0;
        for (int i = 0; i < preorder.length; i++) {
            if (inorder[i] == rootValue) {
                rootIndex = i;
                break;
            }
        }
        //至此我们已经找到了根和左右子树，那么设置一下根节点和左右节点，递归后返回根节点即可
        // 重建一棵树要new每一个树节点！！ 可以把这棵树当成只有三个节点，然后再去递归构建这棵树
        TreeNode root = new TreeNode(rootValue);
        // Arrays.copyOfRange(arr, from, to) 包含from，不包含to，递归的根根节点划分左右区间
        // 还有不要忘了下面是root.left和root.right 不要写TreeNode left right这样root和子节点没有关联起来，
        // 也不要写成TreeNode root.left因为每一次递归都会TreeNode root = new TreeNode(rootValue);因此不需要再新建对象
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, rootIndex + 1),
                              Arrays.copyOfRange(inorder, 0, rootIndex));
        root.right = buildTree(Arrays.copyOfRange(preorder, rootIndex + 1, preorder.length),
                               Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length));
        return root;
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
