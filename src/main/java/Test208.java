import java.util.*;
/**
 * @author: yangchao
 * @createTime: 2022-08-27  20:14
 * @description: 锯齿长城：使数组变成交替数组的最少操作数
 */
public class Test208 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int res = minimumOperations(arr);
        System.out.println(res);
    }
    public static int minimumOperations(int[] nums) {
        // 建立两个map存放奇偶数以及它们的个数，然后找到最多的那个值，分别替换
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int num : nums) {
            if(num % 2 != 0){
                map1.put(num, map1.getOrDefault(num, 0)+1);
            }else {
                map2.put(num, map2.getOrDefault(num, 0)+1);
            }
        }
        // 分别找奇数和偶数中最多的数字
        int max_j = -1, max_o = -1;
        int max_jv = -1, max_ov = -1;
        Set<Map.Entry<Integer, Integer>> entries1 = map1.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries1) {
            if(entry.getValue() > max_jv){
                max_j = entry.getKey();
                max_jv = entry.getValue();
            }
        }
        Set<Map.Entry<Integer, Integer>> entries2 = map2.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries2) {
            if(entry.getValue() > max_ov){
                max_o = entry.getKey();
                max_ov = entry.getValue();
            }
        }

        // 已经分别找到了最多的奇数和偶数对应的元素
        // 替换
        int res1 = 0, res2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i % 2 != 0){
                if(nums[i] != max_j){
                    res1++;
                }
            }else{
                if(nums[i] != max_o){
                    res1++;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(i % 2 != 0){
                if(nums[i] != max_o){
                    res2++;
                }
            }else{
                if(nums[i] != max_j){
                    res2++;
                }
            }
        }
    return Math.min(res1, res2);
    }
}
