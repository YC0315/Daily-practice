import java.util.ArrayList;
import java.util.List;

/**
 * @author: yangchao
 * @createTime: 2022-08-27  08:40
 * @description: 所有可能的路径
 */
public class Test202 {
    // 路径问题使用递归加回溯
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        temp.add(0);  // 一开始都是空的，要先加进去首节点
        dfs(graph, 0);
        return res;
    }

    public void dfs(int[][] graph, int x) {
        if(x == graph.length-1){
            // 到达最后一个节点
            res.add(new ArrayList<>(temp));
            return;
        }
        // 做选择
        for(int i = 0; i < graph[x].length; i++){
            temp.add(graph[x][i]);
            dfs(graph, graph[x][i]);
            temp.remove(temp.size()-1);
        }
    }
}
