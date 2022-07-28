import java.util.Arrays;

/**
 * 插入排序：
 */
public class Test10 {
    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 6, 3, 7, 9};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertSort(int[] arr) {
        if (arr == null || arr.length <= 1 ) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            // 当array[i]比arra[i - 1]小时才进入处理
            if (arr[i] < arr[i - 1]) {
                // 临时变量存储array[i]的值
                int temp = arr[i];
                // 此时下标 i 代表着循环的位置不能移动。因此，我们需要再定义一个变量 j 来记录比较的位置
                int j = i;
                // 将比temp大的数往后挪一个位置，为temp腾出一个合适位置
                while (j > 0 && temp < arr[j - 1]) {  // 必须j>0在前，否则arr[j-1]会爆出超出索引范围异常
                    arr[j] = arr[j - 1];
                    j--;// 填充完后, 继续向前比较
                }
                // 将temp放在属于它的位置上
                arr[j] = temp;
            }
        }
    }
}
