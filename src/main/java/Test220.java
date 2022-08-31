import java.util.Arrays;
import java.util.Collections;

/**
 * @author: yangchao
 * @createTime: 2022-08-30  20:04
 * @description: 最大交换
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 * 示例 1 :
 * 输入: 2736
 * 输出: 7236
 * 解释: 交换数字2和数字7。
 */
public class Test220 {
    public static void main(String[] args) {
        int num = 98368;
        int i = maximumSwap(num);
        System.out.println(i);
    }

    public static int maximumSwap(int num) {
        // 将原数组从大到小排序，然后对比两个字符串，第一次出现不相同时的位置的两元素为应该交换的两个元素，注意应该从后面往前找顺序串中的元素！！
        String s = String.valueOf(num);
        if(s.length() <= 1) return num;
        Integer[] arr = new Integer[s.length()];
        Integer[] brr = new Integer[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i) - '0';
            brr[i] = arr[i];
        }
        // java并没有直接提供数组逆序的api，因此借助工具类，此时brr数组要为Integer类型的！！！！！
        Arrays.sort(brr, Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].equals(brr[i]) ) {
                for (int j = arr.length - 1; j >= 0; j--) {
                    if (arr[j].equals(brr[i])) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                        break;
                    }
                }
                break;
            }
        }
        // arr[]数组转换成字符数组
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < arr.length; k++) {
            sb.append(String.valueOf(arr[k]));
        }
        return Integer.valueOf(sb.toString());
    }
}
