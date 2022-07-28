import java.util.Arrays;

/**
 * @author: yangchao
 * @createTime: 2022-07-13  21:21
 * @description: 寻找数组第K大, 数组包含重复元素，不用去重,如果只用快排时间复杂度很高
 */
public class Test55 {
    public static int findKth(int[] a, int n, int K) {
        // 快排
        quickSort(a, 0, n - 1);
        System.out.println(Arrays.toString(a));
        return a[n - K];
    }

    public static void quickSort(int[] arr, int left, int right) {
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

        quickSort(arr, start, left - 1);  // 注意这快是left-1和left+1因为第left个元素已经有序了
        quickSort(arr, left + 1, end);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 1, 3, 5, 7};
        int n = 5;
        int k = 3;
        System.out.println(findKth(arr, n, k));
    }
}
