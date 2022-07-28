/**
 * @author: yangchao
 * @createTime: 2022-07-13  08:14
 * @description: 斐波那契数列
 */
public class Test52 {
    // 使用动态规划
    public int fib(int n) {
        int a = 1;
        int b = 1;
        int c = 1;
        for (int i = 2; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    // 使用递归加备忘录（剪枝）
    public int fib1(int n) {
        if (n < 2) return n;
        int[] memory = new int[n + 1];
        return helper(memory, n);
    }

    private int helper(int[] memory, int n) {
        if (n == 1 || n == 2) return 1;
        if (memory[n] != 0) return memory[n];

        memory[n] = helper(memory, n - 1) + helper(memory, n - 2);

        return memory[n];

    }

}
