import java.util.Arrays;

/**
 * @author: yangchao
 * @createTime: 2022-07-14  20:30
 * @description: 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 *               快排 ，排序到第k-1的索引位置处(基准处索引等于k-1)时，前k-1个数肯定比k小
 */
public class Test57 {
    public int[] smallestK(int[] arr, int k) {
        int n = arr.length;
        // 快排
        quickSort(arr, 0, n - 1, k);
        return Arrays.copyOfRange(arr, 0, k);
    }

    public static void quickSort(int[] arr, int left, int right, int k) {
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
        if (left == k - 1) {
            return;
            // 接着往右边寻找
        } else if (left < k - 1) {
            quickSort(arr, left + 1, end, k);
        } else {
            // 往左边寻找
            quickSort(arr, start, left - 1, k);  // 注意这快是left-1和left+1因为第left个元素已经有序了
        }
    }
}
