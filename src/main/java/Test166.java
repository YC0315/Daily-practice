import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: yangchao
 * @createTime: 2022-08-16  08:22
 * @description: 找出数组中单独的元素
 */
public class Test166 {
    public static void main(String[] args) {
        // 接受一个数组1 1 2 3 3 4 4
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int[] nums = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
        int num = findOne(nums);
        System.out.println(num);
    }

    public static int findOne(int[] nums) {
        int reslut = 0;
        for (int num : nums) {
            reslut = reslut ^ num;// 异或操作可以找到单独存在的元素
        }
        return reslut;
    }

}
