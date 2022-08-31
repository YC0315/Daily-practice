import java.util.HashMap;
import java.util.Map;

/**
 * @author: yangchao
 * @createTime: 2022-08-31  08:10
 * @description: 使数组变成交替数组的最少操作数,n - x - y
 */
public class Test221 {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        // 统计奇数和偶数下标上最多的元素和次多的元素
        int[] even = calculation(nums, 0);
        int[] odd = calculation(nums, 1);
        if (even[0] != odd[0]) {
            return n - even[1] - odd[1];
        } else {
            return n - Math.max(even[3] + odd[1], even[1] + odd[3]);
        }
    }

    public int[] calculation(int[] nums, int begin) {
        // 使用map统计最多的元素和次多的元素
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = begin; i < nums.length; i += 2) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int firstKey = 0, firstNumber = 0, secondKey = 0, secondNumber = 0;
        for (Integer key : map.keySet()) {
            if(map.get(key) > firstNumber){
                secondKey = firstKey;
                secondNumber = firstNumber;
                firstKey = key;
                firstNumber = map.get(key);
            }else if(map.get(key) > secondNumber){
                secondKey = key;
                secondNumber = map.get(key);
            }
        }
        int[] res = new int[]{firstKey, firstNumber, secondKey, secondNumber};
        return res;
    }
}
