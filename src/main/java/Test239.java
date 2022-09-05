import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author: yangchao
 * @createTime: 2022-09-04  15:25
 * @description: TODO
 */
public class Test239 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //sc.nextLine();
        //int[] a = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int B = 7;
        int[] a = new int[n+1];
        for(int i = 1; i <= n; i++){
            a[i] = sc.nextInt();
        }
        System.out.println(yc(a, B));
    }

    public static int yc(int[] a, int B) {
        int n = a.length-1;
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i <= B; i++){
            res.add(new ArrayList<>());
        }
        for (int i = 1; i <= B; i++) {
            for (int j = i; j <= B; j+=i) {
                res.get(j).add(i);
            }
        }
        int m = res.get(B).size();
        int[] num = new int[B+1];
        for (int i = 0; i < m; i++) {
            num[res.get(B).get(i)] = i;
        }
        int[][] dp = new int[n+1][m];
        for (int i = 1; i < m; i++) {
            dp[0][i] = (int)1e9;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = (int)1e9;
                for(int k = 0; k<res.get(res.get(B).get(j)).size();k++){
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][num[res.get(res.get(B).get(j)).get(k)]])+
                            Math.abs(a[i]-res.get(B).get(j)/res.get(res.get(B).get(j)).get(k));
                }
            }
        }
        return dp[n][m-1];
    }

}
