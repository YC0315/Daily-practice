import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: yangchao
 * @createTime: 2022-07-11  21:32
 * @description: 验证完全二叉树：BFS遍历判断，就2个条件：
 * （1）如果某一个节点，它缺左树，但是有右树，一定不是完全二叉树！
 * （2）如果一个节点，它有左树，但是没有右树，则此时从左往右依次变满，这个节点右树往右今后都不再满了，
 *      所以要求从此后遇到的所有节点，都得是叶节点，才能保证左边是满的过程。！
 *
 *  或者理解成：判断一棵树是否为「完全二叉树」的方式为：
 *             对其进行层次遍历，若遇到一个空结点，则其后面的结点必须全为空结点，否则不是完全二叉树
 */
public class Test49 {
    public static boolean reviewIsCBT(TreeNode root){
        // 使用BFS判断两个条件
        if(root == null) return true;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        // 添加一个条件判断一个节点有没有左右孩子
        boolean flag = false;
        while(!deque.isEmpty()){
            TreeNode node = deque.pop();
            TreeNode left = node.left;
            TreeNode right = node.right;

            // 如果某一个节点，它缺左树，但是有右树，一定不是完全二叉树！
            if(left == null && right != null) return false;

            // 判断第二个条件，该节点在该节点的父节点不左右双全的情况下，该节点还不是叶节点，则不是完全二叉树
            if(flag == true && !(left == null && right == null)) return false;

            if(left != null) deque.add(left);
            if(right != null) deque.add(right);

            if(left == null || right == null) flag = true;  // 判断该节点是不是左右双全，不是，缺孩子了
        }
        return true;
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
