import java.util.Arrays;

/**
 * @author: yangchao
 * @createTime: 2022-08-13  16:38
 * @description: 魔法外卖
 */
public class Test156 {
    public static void main(String[] args) {
        int time = 5;
        int[] nums = {5, 6, 7, 8, 9, 10};
        int count = count(nums, time);
        System.out.println(count);  // 4
    }

    public static int count(int[] nums, int time) {
        Arrays.sort(nums);
        int res = 0;
        int i = 0, j = 0;
        int[] times = new int[nums.length];
        for (int s = 0; s < nums.length; s++) {
            times[s] = (s + 1) * time;
        }
        while (i < nums.length && j < nums.length) {
            if (times[i] <= nums[j]) {
                i++;
                j++;
            } else {
                res++;
                j++;
            }
        }
        return res;
    }
}
