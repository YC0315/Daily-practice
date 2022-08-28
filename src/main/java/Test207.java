import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: yangchao
 * @createTime: 2022-08-27  19:51
 * @description: 嘤嘤觉得长城很美 ，特别是它的锯齿， 非常的优雅！
 * 现在有一个数组，嘤嘤想把这个数组变成"长城"，即对于"长城"中每 一个元 素左右两边的元素相等，并且与它不相等。例如[2，1，2，1，2，1，2），（1，9，1，9}是长城，
 * {2，1，3，2，4，1，4，4，4，4）则不是长城。
 * 你每次可以将一个元素变成另外一个元素，请问最少需要几次操作？
 * 输入：6
 * 1 1 4 5 1 4
 * 输出：3
 */
public class Test207 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();


    }
}
