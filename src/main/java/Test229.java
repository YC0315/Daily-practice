import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: yangchao
 * @createTime: 2022-08-31  21:04
 * @description:
 */
public class Test229 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] start = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] end = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int s = lenth(end);
        System.out.println(n - s);

    }

    public static int lenth(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i = 0; i < nums.length;i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        int ret = 1;
        for(int i = 0; i < dp.length; i++){
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }
}
