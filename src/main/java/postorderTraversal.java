import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author: yangchao
 * @createTime: 2022-07-14  22:14
 * @description: 迭代法实现后序遍历，显示的维护一个栈(后序遍历是左-右-根，入栈顺序是!!!)
 */
public class postorderTraversal {
    // 迭代法：后序遍历
    // 与中序的不同之处在于：
    // 中序遍历中，从栈中弹出的节点，其左子树是访问完了，可以直接访问该节点，然后接下来访问右子树。
    //后序遍历中，从栈中弹出的节点，我们只能确定其左子树肯定访问完了，但是无法确定右子树是否访问过。
    //因此，我们在后序遍历中，引入了一个prev来记录历史访问记录。
    //当访问完一棵子树的时候，我们用prev指向该节点。
    //这样，在回溯到父节点的时候，我们可以依据prev是指向左子节点，还是右子节点，来判断父节点的访问情况。
    public List<Integer> posterTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        //主要思想：
        //由于在某颗子树访问完成以后，接着就要回溯到其父节点去
        //因此可以用prev来记录访问历史，在回溯到父节点时，可以由此来判断，上一个访问的节点是否为右子树
        while (root != null || !stack.isEmpty()) {
            // 将一棵树的左子节点全部加入栈中
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 从栈中弹出的元素，左子树一定是访问完了的
            root = stack.pop();
            //现在需要确定是否有右子树，或者右子树是否访问过
            //如果没有右子树，或者右子树访问完了，也就是上一个访问的节点是右子节点时
            //说明可以访问当前节点（中节点）, 否则按左-右-中的顺序，要先访问右子节点
            if (root.right == null || prev == root.right) {
                // 更新历史访问记录，这样回溯的时候父节点可以由此判断右子树是否访问完成
                res.add(root.val);
                prev = root;  // 在回溯到上一层父节点的时候，我们可以依据prev是指向左子节点，还是右子节点，来判断父节点的访问情况。
                root = null;  // 将root置空，继续从栈顶取出元素
                              // 如果不置空，下一次循环开始的时候，当前节点又会被入栈，就死循环了
            } else {
                // 如果右子树没有被访问，那么将当前节点压栈，先访问右子树
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }

    // 后序遍历取巧方法：后序遍历顺序 左-右-中 入栈顺序定为：中-左-右 出栈顺序：中-右-左， 最后翻转结果左-右-中
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.left != null){
                stack.push(node.left);
            }
            if (node.right != null){
                stack.push(node.right);
            }
        }
        Collections.reverse(result);
        return result;
    }
}
