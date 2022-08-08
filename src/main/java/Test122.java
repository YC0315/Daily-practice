/**
 * @author: yangchao
 * @createTime: 2022-08-05  20:28
 * @description: 跳台阶, 跳台阶问题相当于斐波那契数列，还可以使用动态规划，记住做法！！
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 青蛙跳台阶问题： f(0)=1 , f(1)=1 , f(2)=2
 * 斐波那契数列问题： f(0)=0 , f(1)=1 , f(2)=1
 */
public class Test122 {
    // 节省空间的做法时间:O(n),空间:O(1)
    public int numWays(int n) {
        int a = 1, b = 1;
        int c = 0;
        for (int i = 2; i <= n; i++) {
            c = (a + b) % 1000000007;
            a = b;
            b = c;
        }
        return c;
    }

    // 使用动态规划的做法时间:O(n),空间:O(n)
    public int numWays1(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];  // 这块是n+1，能取到n
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }

}
