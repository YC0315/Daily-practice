import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: yangchao
 * @createTime: 2022-07-12  20:02
 * @description: 斐波那契数列:递归加备忘录
 */
public class Test50 {

    // 做法一：递归加备忘录，时间复杂度是n, 「自顶向下」的做法
    public int fib1(int n) {
        if (n == 0) return 0;
        // 备忘录数组存放每个值，避免重复递归
        int[] memory = new int[n + 1]; // 数组下标从0开始的，因此数组长度要设置成n+1
        return helper(memory, n);
    }

    private int helper(int[] memory, int n) {

        if (n == 1 || n == 2) return 1;
        if (memory[n] != 0) return memory[n]; // 不断递归的同时使用备忘录，避免重复计算

        memory[n] = helper(memory, n - 1) + helper(memory, n - 2); // 每个值只计算一遍
        return memory[n];
    }

    // 做法二：递归，从头开始计算每一个值，时间复杂度n，空间复杂度1，「自底向上」的做法
    public int fib(int n) {
        if(n == 0) return 0;
        int a = 1;
        int b = 1;
        int c = 1; // 假设n==1或n==2则直接返回c
        for (int i = 2; i < n; i++) { // f(n)的下标是n-1
            c = a+b;
            a = b;
            b = c;
        }
        return c;
    }

}
