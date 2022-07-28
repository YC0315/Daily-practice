/**
 * 整数替换：
 * 给定一个正整数 n ，你可以做如下操作：
 * 如果 n 是偶数，则用 n / 2替换 n 。
 * 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
 * 返回 n 变为 1 所需的 最小替换次数 。

 * 输入：n = 8
 * 输出：3
 * 解释：8 -> 4 -> 2 -> 1

 * 输入：n = 7
 * 输出：4
 * 解释：7 -> 8 -> 4 -> 2 -> 1
 * 或 7 -> 6 -> 3 -> 2 -> 1
 */
public class Test08 {
    public static int replaceInt(int n){
        if(n == 1) return 0;

        // 如果为奇数
        if(n % 2 != 0){
            return 1 + Math.min(replaceInt(n+1), replaceInt(n-1));
        }else{
            return 1 + replaceInt(n / 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(replaceInt(7));
    }
}
