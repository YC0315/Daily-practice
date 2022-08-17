import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: yangchao
 * @createTime: 2022-08-16  08:09
 * @description: 归并排序
 */
public class Test165 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.next().split(",");
        int[] nums = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
        split(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void split(int[] nums, int left, int right) {
        // 递归划分数组出口
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        split(nums, left, mid);
        split(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    public static void merge(int[] nums, int left, int mid, int right) {
        // 找到左右两个等待合并的数组的起点
        int l = left;
        int r = mid + 1;
        int i = 0;
        // 创建一个临时数组存放每一次的合并结果
        int[] temp = new int[right - left + 1];
        while (l <= mid && r <= right) {
            temp[i++] = nums[l] < nums[r] ? nums[l++] : nums[r++];
        }
        while (l <= mid) {
            temp[i++] = nums[l++];
        }
        while (r <= right) {
            temp[i++] = nums[r++];
        }
        // 将临时数组中的内容拷贝回原数组
        for (int j = 0; j < temp.length; j++) {
            nums[left + j] = temp[j];
        }
    }
}
