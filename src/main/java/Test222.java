import java.util.Arrays;

/**
 * @author: yangchao
 * @createTime: 2022-08-31  08:32
 * @description: 归并排序
 */
public class Test222 {
    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1, 0};
        split(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
    public static void split(int[] nums, int left, int right){
        // 归并排序，分治的思想，先分再和
        if(left >= right) return;
        int mid = left + (right - left) / 2;
        split(nums, left, mid);
        split(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    public static void merge(int[] nums, int left, int mid, int right) {
        int l = left;  // 左数组的起点索引
        int r = mid + 1;  // 右数组的起点索引
        int i = 0;  // 临时数组的索引
        int[] temp = new int[right - left + 1];
        // 合并
        while(l <= mid && r <= right){
            temp[i++] = nums[l] < nums[r]? nums[l++]:nums[r++];
        }
        while (l <= mid){
            temp[i++] = nums[l++];
        }
        while(r <= right){
            temp[i++] = nums[r++];
        }
        // 拷贝回原数组
        for(int j = 0; j< temp.length; j++){
            nums[j+left] = temp[j];
        }
    }
}
