import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author: yangchao
 * @createTime: 2022-08-16  20:54
 * @description: 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class Test170 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = Arrays.stream(sc.next().split(",")).mapToInt(Integer::parseInt).toArray();
        List<List<Integer>> subsets = subsets(nums);
        System.out.println(subsets);
    }
    // 直接遍历，遇到一个数就把所有子集加上该数组成新的子集，遍历完毕即是所有子集
    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int size = res.size();  // 这块要固定一个长度，否则res的元素是一直在变的
            for (int j = 0; j < size; j++) {
                List<Integer> temp = new ArrayList<>(res.get(j));
                temp.add(nums[i]);
                res.add(temp);
            }
        }
        return res;
    }

}
