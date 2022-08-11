/**
 * @author: yangchao
 * @createTime: 2022-08-11  20:22
 * @description: 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class Test145 {
    // 跑楼梯、跳台阶、斐波那契数列都是一个套路，使用三个数计算当前值，注意边界条件
    public int climbStairs(int n) {
        if(n <= 2) return n;
        int a = 1, b = 2;  // 初始值
        for (int i = 3; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
