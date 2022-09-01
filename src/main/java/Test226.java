import java.util.*;

/**
 * @author: yangchao
 * @createTime: 2022-08-31  18:50
 * @description: TODO
 */
public class Test226 {
    static int s = 0;
    static Integer k = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        k = sc.nextInt();
        sc.nextLine();
        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // 寻找nums的子集，子集中有重复元素
        subsets(nums);
        System.out.println(s);

    }

    private static void subsets(int[] nums) {
        if(k == 1) s+= nums.length;
        for(int i = 0; i <nums.length-1; i++){
            for(int j = i+1; j < nums.length;j++){
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                for(int l = i; l <= j ;l++){
                    max = Math.max(max, nums[l]);
                    min = Math.min(min, nums[l]);
                }
                if(min * k == max) s++;
            }
        }
    }
}
