import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author: yangchao
 * @createTime: 2022-09-03  16:17
 * @description: TODO
 */
public class Test237 {
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> temp = new ArrayList<>();
    static boolean flag;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        Arrays.sort(nums);
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        for(int k = 1; k <= 8; k++){
            flag = false;
            backTrack(nums, 0, k);
            if(!flag){
                System.out.println(k);
            }
        }
    }
    // 可以重复选取的组合问题
    public static void backTrack(int[] nums, int index, int target) {
        // 递归结束
        if(target == 0){
            res.add(new ArrayList<>(temp));
            flag = true;
            return;
        }
        // 去重
        if(target < 0) return;
        // 递归
        for(int j = index; j < nums.length; j++){
            if(j > 0 && nums[j] == nums[j-1]) continue;
            if(target-nums[j] > 0){
                temp.add(nums[j]);
                backTrack(nums, j, target-nums[j]);
                temp.remove(temp.size()-1);
            }
        }
    }
}
