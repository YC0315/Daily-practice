import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: yangchao
 * @createTime: 2022-09-13  16:53
 * @description: TODO
 */
public class Test260 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] s = sc.nextLine().split(" ");
        int[] nums = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
        boolean can = can(nums);
        System.out.println(can);
    }

    public static boolean can(int[] nums) {
        int len = nums.length-1;
        int maxDis = nums[0];
        if(len == 0){
            return true;
        }
        for(int i = 1; i < nums.length; i++){
            if(maxDis >= i){
                int maxTmpDis = i + nums[i];
                if(maxTmpDis >= len){
                    return true;
                }
                if(maxTmpDis > maxDis){
                    maxDis = maxTmpDis;
                }
            }
        }
        return false;
    }
}
