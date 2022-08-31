import java.util.HashMap;
import java.util.Map;

/**
 * @author: yangchao
 * @createTime: 2022-08-30  13:29
 * @description: 使数组编程交替数组的最少操作数
 * 要修改的次数：
 *      times = nums.length - 奇数下标元素最多的次数 - 偶数下标元素最多的次数
 */
public class Test218 {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        // 获取偶数下标序列，记录出现最多次的元素值及对应次数，次多次的元素值及出现的次数
        int[] even = getArray(0, nums);
        // 获取奇数下标序列，记录出现最多次的元素值及对应次数，次多次的元素值及出现的次数
        int[] odd = getArray(1, nums);

        // 奇数下标元素和偶数下标元素不一样时
        if (even[0] != odd[0]) {
            return n - even[1] - odd[1];
        } else {
            // 如果奇数下标元素和偶数下标元素相同，则返回次多的奇数下标元素与偶数下标元素 或者次多的偶数下标元素与奇数下标元素，因为对于奇数或者偶数下标序列来说，最多的元素和次多的元素肯定不相同
            return n - Math.max(even[3] + odd[1], even[1] + odd[3]);
        }
    }

    // 获取最多的元素值及对应的下标，以及次多的元素值及对应的下标
    public int[] getArray(int begin, int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        // 记录每个元素值及对应出现的次数
        for (int i = begin; i < n; i += 2) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        // 初始化最大值及对应的次数，次大值及对应的次数
        int firstKey = 0, firstTime = 0, secondKey = 0, secondTime = 0;
        for (Integer key : map.keySet()) {
            // 如果当前元素出现的次数大于最多元素出现的次数，就替换掉当前元素为最多出现的元素，将上一次最多元素替换为次多元素
            if(map.get(key) > firstTime){
                secondKey = firstKey;
                secondTime = firstTime;
                firstKey = key;
                firstTime = map.get(key);
            }else if(map.get(key) > secondTime){
                // 如果当前元素出现的次数小于最多元素的次数，多于次多元素的次数，就替换为次多元素
                secondKey = key;
                secondTime = map.get(key);
            }
        }
        return new int[]{firstKey, firstTime, secondKey, secondTime};
    }
}
