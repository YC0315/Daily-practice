import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: yangchao
 * @createTime: 2022-07-20  08:16
 * @description: TODO
 */
public class Test71 {
    // 二叉树的中序遍历，后序遍历：迭代法
    public List<Integer> inorder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

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

    // 后序遍历，迭代法
    public List<Integer> postTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            // 取出中间节点
            curr = stack.pop();
            if(curr.right == null || prev == curr.right){
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
