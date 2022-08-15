import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: yangchao
 * @createTime: 2022-08-15  18:37
 * @description: 归并排序，分治思想，先拆再合并
 */
public class Test163 {
    public static void main(String[] args) {
//        int[] nums = {2, 6, 1, 0, 3, 9, 7};
        // 使用ACM模式输入输出
        Scanner sc= new Scanner(System.in);
        String[] string = sc.next().split(",");
        // String[]转int[]
        int[] nums = Arrays.stream(string).mapToInt(Integer::parseInt).toArray();


        //  拆分
        split(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void split(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        split(nums, 0, mid);
        split(nums, mid+1, right);
        merge(nums, left, mid, right);
    }

    public static void merge(int[] nums, int left, int mid, int right) {
        // 合并
        // 找到左右两个数组首元素的位置
        int leftStart = left;
        int rightStart = mid + 1;
        // 创建一个新数组存放合并后的值
        int[] temp = new int[right - left + 1];
        int i = 0;
        while (leftStart <= mid && rightStart <= right) {
            temp[i++] = nums[leftStart] > nums[rightStart] ? nums[rightStart++] : nums[leftStart++];
        }
        while(leftStart <= mid){
            temp[i++] = nums[leftStart++];
        }
        while(rightStart <= right){
            temp[i++] = nums[rightStart++];
        }
        for(int j = 0; j<temp.length;j++){
            nums[left+j] = temp[j];
        }
    }

}
