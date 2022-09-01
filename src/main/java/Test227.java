import java.util.Scanner;

/**
 * @author: yangchao
 * @createTime: 2022-08-31  19:50
 * @description: TODO
 */
public class Test227 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int f = 0; f < t;f++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int x = sc.nextInt();
            int[][] dp = new int[n][m];
            sc.nextLine();
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    dp[i][j] = sc.nextInt();
                }
            }
            if(n == 1){
                int sum = 0;
                for(int j = 0; j < m;j++){
                    sum += dp[n][j];
                }
                if(sum == x){
                    System.out.println("yes");
                }else{
                    System.out.println("no");
                }
                continue;
            }
            int[][] maxt = new int[n][m];
            for(int i = 1; i < n; i++){
                for(int j = 1; j < m; j++){
                    maxt[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
            if(maxt[n-1][m-1] == x){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }
    }
}
