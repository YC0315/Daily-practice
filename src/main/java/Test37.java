import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: yangchao
 * @createTime: 2022-07-05  20:50
 * @description: 两数之和
 */
public class Test37 {
    public static void main(String[] args) {
        int[] nums = {2,5,5,11};
        int target = 10;
        int[] twoSum = twoSum(nums, target);
        System.out.println(Arrays.toString(twoSum));
        // 一下两种方式可以实现数组的截取拷贝
//        System.arraycopy();
//        Arrays.copyOfRange()
    }

    // 可以使用两层for循环的方式，但是时间复杂度为O(n2),要优化时间复杂度可以使用哈希表
    // 对于无序数组查找值，要想到哈希表和差值这两个东西！！！！
    /*
        两个元素x，y必然是一前一后出现的，如果存在符合条件的解，在遍历到x时，哈希表里没有符合的y，
        此时把x加入到了哈希表里，当遍历到y时，就可以在哈希表里找到对应的x了，所以只需要一次遍历
     **/
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);  // 将当前值与其索引放入map，然后下次去寻找是否与当前值求和等于target的值
        }
        return new int[]{};
    }
}
