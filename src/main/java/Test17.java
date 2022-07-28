import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 四数之和：
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
 * 请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] 
 * （若两个四元组元素一一对应，则认为两个四元组重复）：
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * <p>
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 */
public class Test17 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        int a = 0;
        int d = len - 1;
        while (a <= d - 3) {
            int b = a + 1;
            int c = d - 1;
            int temp = target - nums[a] - nums[d];
            while (b < c) {
                if ((nums[b] + nums[c]) > temp) {
                    c--;
                } else if ((nums[b] + nums[c]) < temp) {
                    b++;
                } else if ((nums[b] + nums[c]) == temp) {
                    Integer[] arr = {nums[a], nums[b], nums[c], nums[d]};
                    Arrays.sort(arr);
                    List<Integer> list = new ArrayList<>();
                    Collections.addAll(list, arr);
                    if (!res.contains(list)) {
                        res.add(list);
                    }

                    b++;
                    c--;
                }
            }
            if (temp > 0) {
                a++;
            } else if (temp < 0) {
                d--;
            } else {
                Integer[] arr = {nums[a], nums[b], nums[c], nums[d]};
                Arrays.sort(arr);
                List<Integer> list = new ArrayList<>();
                Collections.addAll(list, arr);
                if (!res.contains(list)) {
                    res.add(list);
                }
                a++;
                d--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,-1,-1,1,1,2,2};
        int target = 0;
        List<List<Integer>> res = fourSum(nums, target);
        System.out.println(res);

    }

}
