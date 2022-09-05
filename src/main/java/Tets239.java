import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author: yangchao
 * @createTime: 2022-09-03  19:09
 * @description: TODO
 */
public class Tets239 {
    static int res = 0;
    static int[] first = new int[2];
    static int[] last = new int[2];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();  // l千米
        int m = sc.nextInt();  // m只蚂蚁
        int[][] dp = new int[m][2];
        for(int i = 0; i < m; i++){
            dp[i][0] = sc.nextInt();
            dp[i][1] = sc.nextInt();
            if(dp[i][0] == 1) first = dp[i];
            if(dp[i][1] == l) last = dp[i];
        }

        if(first[0] == 0 || last[1] == 0) System.out.println("fail");
        merge(dp);
        System.out.println(res);
    }
    public static void merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // 区间按左界排序
        List<int[]> resList = new ArrayList<>();
        int[] pre = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            int[] cur = intervals[i];
            int preLeft = pre[0], preRight = pre[1];
            int curLeft = cur[0], curRight = cur[1];
            if(preRight >= curLeft || preRight == curLeft-1){ // 发生合并，暂时不放入res中
                pre = new int[] {preLeft, Math.max(preRight, curRight)};
                res++;
                if(curRight == last[1]){
                    return;
                }
            }
            else{
                resList.add(pre); // pre与cur未发生合并
                pre = cur;
            }
        }
        resList.add(pre);
        return;
    }
}
