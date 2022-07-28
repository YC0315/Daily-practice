import java.util.*;


/**
 * @author: yangchao
 * @createTime: 2022-07-16  08:28
 * @description: TODO
 */
public class Test61 {
    // 二叉树的中序遍历：迭代
    public List<Integer> inorder(TreeNode root){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,1);
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()){
            if (curr != null){
                stack.push(curr);
                curr = curr.left;
            }else{
                curr = stack.pop();
                res.add(curr.val);
                curr = curr.right;
            }
        }
        return res;
    }

    // 二叉树的后序遍历：迭代法
    public List<Integer> preOrder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();  // 访问栈中的元素
            // 将中间节点加入列表
            if(root.right == null || prev == root.right){
                res.add(root.val);
                prev = root;
                root = null; // 不置成空会死循环
            }else{
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }
}
