import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author: yangchao
 * @createTime: 2022-06-28  19:19
 * @description: 数组中出现次数超过一半的元素, 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 */
public class Test28 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        int element = majorityElement2(arr);
        System.out.println(element);
    }

    public static int majorityElement(int[] nums) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums) {
            if (map.get(num) == null) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
                if (map.get(num) > length / 2) {
                    return num;
                }
            }
        }
        return 0;
    }

    public static int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // 摩尔投票:众数的个数多余其他数的个数，众数记为1，其他数记为-1，将其都加起来，和肯定大于0.
    // 核心理念为 票数正负抵消,方法时间和空间复杂度分别为 O(N)O(N) 和 O(1)O(1)

    // 我们遍历数组 nums 中的所有元素，对于每个元素 x，在判断 x 之前，如果 count 的值为 0，
    // 我们先将 x 的值赋予 candidate，随后我们判断 x：
    //      如果 x 与 candidate 相等，那么计数器 count 的值增加 1；
    //      如果 x 与 candidate 不等，那么计数器 count 的值减少 1。
    public static int majorityElement2(int[] nums) {
        // 候选众数
        Integer candidate = null;
        // 候选众数的个数
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }


}
