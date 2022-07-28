/**
 * @author: yangchao
 * @createTime: 2022-07-18  19:55
 * @description: 山脉数组的峰顶索引
 * 输入：arr = [0,10,5,2]
 * 输出：1
 */
public class Test65 {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
                return mid;
            }
            if(arr[mid] < arr[mid+1]){
                left = mid + 1;
            }
            if(arr[mid] > arr[mid+1]){
                right = mid;  // 不能扔掉，画一画看看
            }
        }
        return -1;
    }
}
