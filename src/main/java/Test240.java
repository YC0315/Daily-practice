import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: yangchao
 * @createTime: 2022-09-04  17:16
 * @description: TODO
 */
public class Test240 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = 7;
        int[] nums = new int[n];
        for(int i =0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        int[][] dp = new int[n+1][target+1];
        //for(int i = 0; i < n+1; i++) Arrays.fill(dp[i], -1);
        int sum = 0;
        for(int i = 1; i <= n; i++){
            sum += nums[i-1]-1;
            dp[i][1] = sum;
        }
        for(int j = 1; j <= target; j++){
            dp[1][j] = Math.abs(j-nums[0]);
        }
        int result = helper(dp, n, target, nums);
        System.out.println(Math.abs(result));
    }

    public static int helper(int[][] dp, int n, int target, int[] nums) {
        if(dp[n][target] != -1){
            return dp[n][target];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= target; i++) {
            if(target % i != 0){
                continue;
            }
            int j = target / i;
            min = Math.min(min, helper(dp, n-1, j, nums)+Math.abs(nums[n-1]-i));
        }
        return dp[n][target] = min;
    }
}
