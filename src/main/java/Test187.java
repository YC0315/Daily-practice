import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author: yangchao
 * @createTime: 2022-08-21  14:40
 * @description: 子集 II
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * 示例 1：
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 */
public class Test187 {
    // acm模式
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(","))
                .mapToInt(Integer::parseInt).toArray();
        List<List<Integer>> list = subsetsWithDup(arr);
        System.out.println(list);
    }

    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        // 使用双层循环
        // 因为有重复元素，先排序
        Arrays.sort(nums);
        if (nums.length == 0) return res;
        int n = nums.length;
        int lastLen = 1; // 上次开始添加时的位置
        res.add(new ArrayList<>()); // 加入一个空列表
        for (int i = 0; i < n; i++) {
            int size = res.size();
            if (i > 0 && nums[i] != nums[i - 1]) {
                lastLen = size;
            }
            // 当这次添加的元素和上次添加的元素不同，那么从头添加，如果相同，lastLen为上一次res的长度值
            // 则从上一次的最后一个元素开始添加
            for (int j = size - lastLen; j < size; j++) {
                List<Integer> temp = new ArrayList<>(res.get(j));
                temp.add(nums[i]); // 将当前元素添加到每一个从res中取出来的列表
                res.add(temp);
            }
        }
        return res;
    }
}
