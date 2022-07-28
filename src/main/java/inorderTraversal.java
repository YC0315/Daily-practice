import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**
 * @author: yangchao
 * @createTime: 2022-07-14  21:10
 * @description: 迭代法实现中序遍历，显示的维护一个栈(中序遍历是左-根-右，入栈顺序是左-根-右!!!)
 */
public class inorderTraversal {
    public List<Integer> inordertraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()){
            // 先将根节点和左子节点都入栈
            if(curr != null){
                stack.push(curr);
                curr = curr.left;
            }else{
                // 弹出根节点，将值加入列表
                curr = stack.pop();
                res.add(curr.val);
                curr = curr.right;  // 将右子节点入栈
            }
        }
        return res;
    }
}
