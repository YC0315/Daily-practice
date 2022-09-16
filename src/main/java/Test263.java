import java.util.*;

/**
 * @author: yangchao
 * @createTime: 2022-09-14  18:43
 * @description: TODO
 */
public class Test263 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        Arrays.sort(coins);
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - amount] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int num = 2134876;
        maximumSwap(num);
    }
    public static int maximumSwap(int num) {
        // 将原数字从大到小排序，然后对比两个字符串，第一次出现不相同时的位置的两元素为应该交换的两个元素，注意应该从后面往前找顺序串中的元素
        int oringeNum = num;
        char[] chars = String.valueOf(num).toCharArray();
        char[] oringeChars = String.valueOf(oringeNum).toCharArray();
        Arrays.sort(chars);

        int n = chars.length;
        char oringeTemp = ' ';
        char temp = ' ';
        for(int k = 0; k < n; k++){
            if(oringeChars[k] != chars[n-k-1]){
                oringeTemp = oringeChars[k];
                temp = chars[n-k-1];
                oringeChars[k] = temp;
                break;
            }
        }
        for(int k = n-1; k >= 0; k--){
            if(oringeChars[k] == temp){
                oringeChars[k] = oringeTemp;
                break;
            }
        }

        return Integer.valueOf(String.valueOf(oringeChars));
    }
}
