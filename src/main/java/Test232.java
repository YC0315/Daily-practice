import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: yangchao
 * @createTime: 2022-09-01  20:26
 * @description: TODO
 */
public class Test232 {
    public int maxValue (TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        int maxSum = 0;
        int lastGap = 0;

        while(deque.size()>0){
            int n = deque.size();
            int nextGap = 0;
            int eachSum = 0;
            int last = 0;

            while(n>0){
                TreeNode node = deque.removeFirst();
                eachSum += node.val;
                if(node.left!=null){
                    deque.add(node.left);
                    nextGap = Math.max(nextGap,node.left.val-node.val);
                    last = Math.max(last,node.val-node.left.val);
                }
                if(node.right!=null){
                    deque.add(node.right);
                    nextGap = Math.max(nextGap,node.right.val-node.val);
                    last = Math.max(last,node.val-node.right.val);
                }
                n--;
            }
            eachSum += Math.max(lastGap,nextGap);
            maxSum = Math.max(maxSum,eachSum);
            lastGap = last;
        }
        return maxSum;
    }
}
