import java.util.*;

/**
 * @author: yangchao
 * @createTime: 2022-07-10  21:35
 * @description: 根据先序遍历和中序遍历，找到二叉树的右视图！！
 */
public class Test44 {

    // 一种方法是先构建出二叉树，然后层序遍历
    public int[] solve (int[] xianxu, int[] zhongxu) {
        TreeNode tree = buildTree(xianxu, zhongxu);
        List<Integer> list = rightSideView(tree);
        // List集合转int[]数组
        int[] ints = list.stream().mapToInt(Integer::intValue).toArray();
        return ints;
    }

    // 先序遍历和后序遍历的输入都是整形数组，必须首先重建二叉树
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
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, rootIndex + 1),
                Arrays.copyOfRange(inorder, 0, rootIndex));
        root.right = buildTree(Arrays.copyOfRange(preorder, rootIndex + 1, preorder.length),
                Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length));
        return root;
    }

    // 得到二叉树后再通过层序遍历找到二叉树的右视图
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        // 层序遍历，准备一个队列
        Deque<TreeNode> deque = new LinkedList<>();
        // 准备一个数组存放右视图节点值
        List<Integer> res = new ArrayList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pop();
                if (i == size - 1) {
                    res.add(node.val);
                }
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
            }
        }
        return res;
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
