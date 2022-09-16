import java.util.*;

/**
 * @author: yangchao
 * @createTime: 2022-09-14  13:47
 * @description: TODO
 */
public class Test261 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int i = subarraySum(nums, 0);
        System.out.println(i);
    }
    public static int subarraySum(int[] nums, int k){
        int len = nums.length;
        int res = 0;
        int[] prefix = new int[len+1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i = 1; i <= len; i++){
            prefix[i] = prefix[i-1]+nums[i-1];
            if(map.containsKey(prefix[i]-k)){
                res+=map.get(prefix[i]-k);
            }
            map.put(prefix[i], map.getOrDefault(prefix[i], 0)+1);
        }
        return res;
    }
}
