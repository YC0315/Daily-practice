import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author: yangchao
 * @createTime: 2022-09-03  17:06
 * @description: TODO
 */
public class Test238 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i] + 1;
            } else if(nums[i] < nums[i-1]) {
                int j = i;
                while (j >= 1 && nums[j] < nums[j - 1]) {
                    dp[j - 1] = dp[j]+1;
                    j--;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < dp.length; i++) {
            sum += dp[i];
        }
        System.out.println(sum);
    }
}
