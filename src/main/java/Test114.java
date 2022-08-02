import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: yangchao
 * @createTime: 2022-08-01  19:41
 * @description: 根据前序遍历和中序遍历重建二叉树
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 */
public class Test114 {
    // 存放中序遍历的键值映射，避免多次重复扫描中序数组寻找根节点的位置
    public TreeNode reConstructBinaryTree(int [] pre,int [] vin) {
        if (pre == null || pre.length == 0) return null;
        int head = pre[0];
        // 找到前序数组中头节点在中序数组中的索引
        int index = 0;
        for (int i = 0; i < vin.length; i++) {
            if (vin[i] == head) {
                index = i;
                break;
            }
        }
        // 构建树节点
        TreeNode root = new TreeNode(head);
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, index + 1),
                Arrays.copyOfRange(vin, 0, index));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, index + 1, pre.length),
                Arrays.copyOfRange(vin, index + 1, vin.length));

        return root;
    }
}
/*class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}*/
