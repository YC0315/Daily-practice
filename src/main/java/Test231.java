import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author: yangchao
 * @createTime: 2022-09-01  11:05
 * @description: TODO
 */
public class Test231 {
    public static void main(String[] args) {

    }
    public static int maxValue (TreeNode root) {
        // 层序遍历，记录每层的最小值和最大值，相同层之间最大值和最小值交换，然后求和
        if(root == null) return 0;
        // 维护一个栈
        int maxV = 0;
        Stack<TreeNode> stack = new Stack<>();
        List<List<Integer>> list = new ArrayList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            int size = stack.size();
            List<Integer> list2 = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = stack.pop();
                list2.add(node.val);
                if(node.left != null){
                    stack.push(node.left);
                }
                if(node.right != null){
                    stack.push(node.right);
                }
            }
            Collections.sort(list2);
            list.add(list2);
        }
        for(int i = 0; i < list.size()-1; i++){
            List<Integer> a = list.get(i);
            List<Integer> b = list.get(i + 1);
            int max = b.get(b.size()-1);
            int sum = 0;
            for(int j = 1; j < a.size(); j++){
                sum += a.get(j);
            }
            maxV = Math.max(max, sum+max);
        }
        return maxV;
    }
}
