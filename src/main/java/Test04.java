import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 三角形的最小路径和：
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 */
public class Test04 {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int number = 0;
        int size = triangle.size();
        for(int i = 0; i < size; i++){
            Integer min = Collections.min(triangle.get(i));
            number = number + min;
        }
            return number;
    }


    public static void main(String[] args) {

        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        triangle.add(new ArrayList<Integer>(Arrays.asList(2)));
        triangle.add(new ArrayList<Integer>(Arrays.asList(3,4)));
        triangle.add(new ArrayList<Integer>(Arrays.asList(6,5,7)));
        triangle.add(new ArrayList<Integer>(Arrays.asList(4,1,8,3)));
        //System.out.println(Arrays.toString(triangle.toArray()));
        System.out.println(minimumTotal(triangle));
    }
}
