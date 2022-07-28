import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: yangchao
 * @createTime: 2022-07-11  19:05
 * @description: 按之字形顺序打印二叉树
 */
public class Test45 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(pRoot == null) return res;
        // 创建一个队列用于层序遍历
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(pRoot);
        // 使用一个标志位，控制插入临时列表的顺序，是正序插入还是逆序插入
        int flag = 1;
        while(!deque.isEmpty()){
            int size = deque.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pop();
                if(flag == 1){
                    // 正序插入
                    temp.add(node.val);
                }else{
                    // 逆序插入
                    temp.add(0, node.val);
                }
                if(node.left != null){
                    deque.add(node.left);
                }
                if(node.right != null){
                    deque.add(node.right);
                }
            }
            flag = - flag;
            res.add(temp);
        }
        return res;
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
