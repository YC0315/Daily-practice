import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: yangchao
 * @createTime: 2022-07-28  09:03
 * @description: 二叉树的迭代遍历
 */
public class Test101 {
    // 二叉树的中序遍历，迭代法。左-中-右
    public List<Integer> inorder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        // 使用栈显示的模拟递归
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }

    // 后序遍历，迭代法,左-右-中
    public List<Integer> postTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        // 使用栈显示的模拟递归
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        TreeNode curr = root;
        while(curr != null||!stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if(prev == curr.right || curr.right == null){
                res.add(curr.val);
                prev = curr;
                curr = null;
            }else{
                stack.push(curr);
                curr = curr.right;
            }
        }
        return res;
    }

}
