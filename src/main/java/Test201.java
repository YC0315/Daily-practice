import java.util.ArrayList;
import java.util.List;

/**
 * @author: yangchao
 * @createTime: 2022-08-26  16:39
 * @description: 所有可能的路径
 * 给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
 *  graph[i] 是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点 graph[i][j]存在一条有向边）。
 * 输入：graph = [[1,2],[3],[3],[]]
 * 输出：[[0,1,3],[0,2,3]]
 * 解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
 */
public class Test201 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // 使用dfs+回溯
        // 确定递归结束条件
        temp.add(0);  // 从头出发，因此每一个返回结果中都有头结点
        dfs(graph, 0);  // x表示当前节点是第几个节点
        return res;
    }

    public void dfs(int[][] graph, int x) {
        if(x == graph.length-1){
            // 如果已经递归到了（n-1）最后一个节点，就找到了一条有效路径
            res.add(new ArrayList<>(temp));
            return;
        }

        // 做选择
        // 接下来是走 当前遍历节点x的下一个节点。
        // 首先是要找到 x节点链接了哪些节点呢？
        // 遍历节点x链接的所有节点
        for (int i = 0; i < graph[x].length; i++) {  // 这里是graph[x]的长度，
            temp.add(graph[x][i]);
            // 当前遍历的节点就是 graph[x][i] 了，所以进入下一层递归, graph[x][i]就是一个又一个的节点！！，只不过是x节点可以连接到的节点
            dfs(graph, graph[x][i]);
            // 最后就是回溯，撤销本次添加节点的操作
            temp.remove(temp.size()-1);
        }
    }
}
