/**
 * @author: yangchao
 * @createTime: 2022-07-21  20:37
 * @description: 合并两个有序数组
 */
public class Test82 {
    public void merge(int A[], int m, int B[], int n) {
        // 使用双指针，由于不能额外定义数组，所以从后往前遍历比较
        int left = m - 1;
        int right = n - 1;
        int index = m + n - 1;  // 从A数组的最大索引开始遍历
        while (left >= 0 && right >= 0) {
            A[index--] = A[left] < B[right] ? B[right--] : A[left--];
        }
        // 还要检查B数组的指针坐标，防止出现[4,5,6,0,0,0][1,2,3]-->[4,5,6,4,5,6]这种情况
        while (right >= 0) {
            A[index--] = B[right--];
        }
    }
}
