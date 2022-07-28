import java.util.Random;

/**
 * @author: yangchao
 * @createTime: 2022-07-14  19:44
 * @description: 寻找数组第 K 大, 数组包含重复元素，不用去重,如果只用快排时间复杂度很高,因此优化了一下，
 *  假如排序后当前基准元素的索引等于我们要找的值的索引直接返回，假如left<n-k表示待排序的元素在left右边，就
 *  排序当前基准到最后侧的数组，否则排序左侧数组。
 */
public class Test56 {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 1, 3, 5, 7};
        int k = 5;
        System.out.println(findKthLargest(arr, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        // 快排
        quickSort(nums, 0, n - 1, n, k);
        return nums[n-k];
    }

    // 加入n和k参数，是为了寻找第K大的元素的索引
    public static void quickSort(int[] arr, int left, int right, int n, int k) {
        if (left >= right) return;  // 1.递归出口就是只有一个元素了，就不需要排序了

        // 2.选定基准,这个基准一定设置成值!!! 不要设置成left索引，因为数组中该索引处的值随着排序会发生变化
        int prior = arr[left];
        int start = left;
        int end = right;
        while (left < right) {
            while (arr[right] >= prior && left < right) {
                right--;
            }
            arr[left] = arr[right];
            while (arr[left] <= prior && left < right) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = prior;
        // 优化快排整个数组
        // 假如当前排序元素的索引等于待寻找元素处的索引，直接返回
        if (left == n - k) {
            return;
        } else if (left < n - k) {
            quickSort(arr, left + 1, end, n, k);
        } else {
            quickSort(arr, start, left - 1, n, k);  // 注意这快是left-1和left+1因为第left个元素已经有序了
        }
    }
}
