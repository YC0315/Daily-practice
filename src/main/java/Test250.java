import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: yangchao
 * @createTime: 2022-09-07  21:16
 * @description: 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 */
public class Test250 {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0) return new int[0][2];
        // 先将二维数组按左端进行升序排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // 创建一个返回值数组
        List<int[]> merged = new ArrayList<>();
        // 拿出第一个数组来与后面的数组进行比较
        int[] pre = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            int[] curr = intervals[i];
            int preleft = pre[0], preright = pre[1];
            int currleft = curr[0], currright = curr[1];
            // 假如可以合并则右边界选择可以合并的两个数组中的最大值
            if(preright >= currleft){
                pre = new int[] {preleft, Math.max(preright, currright)};
            }else{
                // 假如不可以合并，也就是不连续，就直接添加到返回列表中
                merged.add(pre);
                pre = curr;
            }
        }
        // 对于最后一个数组，合并不合并都是pre，将其添加进返回列表中
        merged.add(pre);
        // 将list转为数组,这里需要传入目标类型的泛型
        return merged.toArray(new int[merged.size()][]);
    }
}
