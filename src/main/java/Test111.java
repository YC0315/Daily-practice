import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: yangchao
 * @createTime: 2022-07-31  21:58
 * @description: 树的前序遍历，后序遍历，中序遍历迭代法
 */
public class Test111 {
    // 前序遍历，根-左-右
    public List<Integer> preTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);   // 先让根节点入栈
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }
        return res;
    }

    // 中序遍历，左-根-右
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else{
                // 下面这些代码是在else里面的！！
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }

    // 后序遍历，左-右-根
    public List<Integer> postTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode prev = null;
        while(curr != null || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            // 当左子树为空，依次弹出节点，并检查其右子树
            curr = stack.pop();
            if(curr.right == null || prev == curr.right){
                res.add(curr.val);
                prev = curr;
                curr = null;
            }else {
                stack.push(curr);
                curr = curr.right;
            }
        }
        return res;
    }
}
// 手写一棵树
/*class TreeNode{
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
}*/
