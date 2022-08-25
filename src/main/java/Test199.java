import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: yangchao
 * @createTime: 2022-08-25  20:11
 * @description: TODO
 */
public class Test199 {
    List<List<Integer>> ans = new ArrayList<>();
    Deque<Integer> stack = new ArrayDeque<>();
    public int DagPathNum (int[][] nodes) {
        stack.offerLast(0);
        dfs(nodes, 0, nodes.length-1);
        return ans.size();

    }

    public void dfs(int[][] graph, int x, int n) {
        if(x == n){
            ans.add(new ArrayList<>(stack));
            return;
        }
        for(int y:graph[x]){
            stack.offerLast(y);
            dfs(graph, y, n);
            stack.pollLast();
        }
    }
}
