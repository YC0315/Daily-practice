import java.util.Arrays;

/**
 * @author: yangchao
 * @createTime: 2022-08-03  08:22
 * @description: 快排
 */
public class Test120 {
    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 1, 9};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        // 设置递归出口
        if (left >= right) return;
        // 选定基准
        int prior = arr[left];
        int start = left;
        int end = right;
        while (left < right) {
            while (prior < arr[right] && left < right) {
                right--;
            }
            arr[left] = arr[right];
            while (prior > arr[left] && left < right) {
                left++;
            }
            arr[right] = arr[left];
        }
        // 找到基准所在位置，区分开左右数组
        arr[left] = prior;
        // 左数组排序
        quickSort(arr, start, left - 1);
        // 右数组排序
        quickSort(arr, left + 1, end);
    }
}
