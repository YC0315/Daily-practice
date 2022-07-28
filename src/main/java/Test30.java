import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: yangchao
 * @createTime: 2022-06-29  19:57
 * @description: 斐波那契数列
 */
/*
写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。取模就是取余%
 */
public class Test30 {
    public static void main(String[] args) {
        System.out.println(fib2(5));
        int[] arr = {0,1,2,3,4,5,6};
        int[] ints = Arrays.copyOfRange(arr, 2, 4);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    // 滚动数组动态规划思想，不使用递归，求出每一项的值，直至找到所求项
    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] arr = new int[n + 1]; // 存放每一个值
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1000000007;
        }
        return arr[n];
    }
    // 上一个做法可以继续优化，不必维护一个N长度的数组,每计算完一个数，就往前替换原变量的值
    public static int fib1(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int temp = 0;
        int f0 = 0;
        int f1 = 1;
        for (int i = 2; i <= n; i++) {
            temp  = (f0 + f1) % 1000000007;
            f0 = f1;
            f1 = temp;
        }
        return temp;
    }
    // 使用递归方法，但是会超时，因此此处使用记忆递归，存一个hashmap缓存，先去查缓存
    // 维护一个HashMap
    static Map<Integer, Integer> map = new HashMap<>();
    public static int fib2(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        if(map.get(n) != null){
            return map.get(n);
        }
        int sum = (fib(n-1) + fib(n-2))%1000000007;
        map.put(n, sum);  // 将计算完的下一个值放入缓存中

        return map.get(n);
    }
}
