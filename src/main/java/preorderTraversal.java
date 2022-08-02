import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: yangchao
 * @createTime: 2022-07-14  21:04
 * @description: 迭代法实现先序遍历，显示的维护一个栈(先序遍历是根-左-右，因此入栈顺序是根-右-左)
 */
public class preorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        // 显示的维护一个栈
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            // 因为栈是先进后出的，所以先添加右子树，后添加左子树
            // 下一次出栈的时候，先添加到数组res中的就是左子树的值了
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
        return res;
    }
}
// 手写一棵树
/*
class TreeNode{
   int val;
   TreeNode left;
   TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
*/
