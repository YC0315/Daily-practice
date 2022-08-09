import java.util.*;

/**
 * @author: yangchao
 * @createTime: 2022-08-08  19:28
 * @description: 三数之和
 */
public class Test130 {

    static List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        // 排序
        Arrays.sort(nums);
        // 大体思路固定住一个节点，其他两个节点使用双指针缩小范围查找，同时避免使用重复元素
        for (int first = 0; first < n; first++) {
            // 在每一次循环的时候，都不使用重复元素
            if (first > 0 && nums[first] == nums[first - 1]) continue;
            int target = -nums[first];  // 定义求和目标值
            int third = n - 1;  // 定义右指针
            for (int second = first + 1; second < third; second++) {
                // 不能使用重复元素
                if (second > first + 1 && nums[second] == nums[second - 1]) continue;
                // 寻找是否满足目标条件
                while (second < third && nums[second] + nums[third] > target) {
                    third--;
                }
                // 假如左右指针重合，则说明没有满足条件的值，则第一个节点first继续往后遍历
                if (second == third) break;
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    res.add(list);
                }
            }
        }
        return res;
    }

    public static List<List<Integer>> threeSum1(int[] nums) {
        if (nums == null || nums.length <= 2) return res;
        int n = nums.length;
        // 排序
        Arrays.sort(nums);
        // 大体思路固定住一个节点，其他两个节点使用双指针缩小范围查找，同时避免使用重复元素
        for (int first = 0; first < n; first++) {
            // 在每一次循环的时候，都不使用重复元素
            if (first > 0 && nums[first] == nums[first - 1]) continue;
            int target = -nums[first];  // 定义求和目标值
            int left = first + 1;
            int right = n - 1;  // 定义右指针
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    if(!res.contains(list)) res.add(list);
                    left++;
                    right--;
                }else if(nums[left] + nums[right] < target){
                    left++;
                    // 去除重复元素
                    if (left > first + 1 && nums[left] == nums[left - 1])continue;
                }else{
                    right--;
                    if (right < n - 1 && nums[right + 1] == nums[right])continue;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-40, -10, -10, 10, 20, 0};
        threeSum1(nums);
        System.out.println(res);
    }
}
