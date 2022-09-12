import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yangchao
 * @createTime: 2022-09-08  08:15
 * @description: 合并区间，判断左右下标是否连续
 */
public class Test251 {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0) return new int[0][2];
        // 先对数组进行排序，按第一维度升序排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // 设定返回值列表
        List<int[]> res = new ArrayList<>();
        int[] pre = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            int[] cur = intervals[i];
            int preleft = pre[0], preright = pre[1];
            int curleft = cur[0], curright = cur[1];
            if(preright >= curleft){
               // 假如连续则不加入res中，继续比较,更新pre的值
                pre= new int[]{preleft, Math.max(preright, curright)};
            }else{
                // 假如不连续则将pre加入res中，并且更新pre的值
                res.add(pre);
                pre = cur;
            }
        }
        // 对于最后一个pre，都将其加入res中
        res.add(pre);
        // 将list转为数组
        return res.toArray(new int[res.size()][]);
    }
}
