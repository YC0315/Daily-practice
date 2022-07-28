/**
 * @author: yangchao
 * @createTime: 2022-07-22  19:25
 * @description: 二维有序数组中查找某个值
 */
public class Test87 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int m = 0;
        int n = matrix[0].length - 1;
        while (m < matrix.length && n >= 0) {
            if (matrix[m][n] == target) {
                return true;
            } else if (matrix[m][n] > target) {  // 这块一定是判断大于，否则会错过当前行
                n--;
            } else {
                m++;
            }
        }
        return false;
    }
}
