import java.util.Arrays;

/**
 * 归并排序：
 */
public class Test06 {
    // 分类
    public static int[] mergeSort1(int[] arr) {
        // 如果数组长度小于2，直接返回
        if (arr.length < 2) {
            return arr;
        }
        int mid = arr.length / 2;
        //Arrays.copyOfRange(array, from, to),用来拷贝一个数组，也可以用来截取数组并拷贝到一个新数组，包含原数组的from索引，不包含原数组的to索引！
        int[] leftArr = Arrays.copyOfRange(arr, 0, mid);// 包括左边界，不包括右边界
        int[] rightArr = Arrays.copyOfRange(arr, mid, arr.length);

        // 合并左右数组
        return merge1(mergeSort1(leftArr), mergeSort1(rightArr));  // 用分治思想，假设只有两个数，将两个数分开然后合并！
    }

    public static int[] merge1(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        // 合并
        while (left.length > 0 && right.length > 0) {
            if (left[0] < right[0]) {
                result[i++] = left[0];
                // copy一个数组来相当于删除首元素
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }
        // 当一个数组为空时，检查剩余数组
        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }
        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {8, 4, 5, 7, 1, 3, 6, 2};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    // 归并排序
    private static void mergeSort(int[] nums, int left, int right) {
        // 拆分
        if (left >= right) return;
        int mid = left + ((right - left) >> 2);
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }
    // 合并
    private static void merge(int[] nums, int left, int mid, int right) {
        int leftStart = left;
        int rightStart = mid + 1;  // 右数组的起点是中间节点mid的下一个
        int[] temp = new int[right - left + 1];
        int index = 0;
        while (leftStart <= mid && rightStart <= right) {
            temp[index++] = nums[leftStart] < nums[rightStart] ? nums[leftStart++] : nums[rightStart++];
        }
        while (leftStart <= mid) {
            temp[index++] = nums[leftStart++];
        }
        while (rightStart <= right) {
            temp[index++] = nums[rightStart++];
        }
        // 拷贝回原数组
        for (int i = 0; i < temp.length; i++) {
            nums[i + left] = temp[i];
        }
    }
}
