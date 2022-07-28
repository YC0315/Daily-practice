import java.util.PriorityQueue;

/**
 * 有序矩阵中第 K 小的元素:
 * 给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素
 * 你必须找到一个内存复杂度优于 O(n2) 的解决方案。
 * 输入：matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
 * 输出：13
 * 解释：矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13
 */

public class test07 {
    public static int kthSmallest(int[][] matrix, int k) {
        int row=matrix.length;
        int cow=matrix[0].length;
        if(k==0||row*cow<k){
            return 0;
        }
        PriorityQueue<Integer> head=new PriorityQueue<>((O1,O2)->O2-O1);
        for(int i=0;i<row;i++ ){
            for(int j=0;j<cow;j++){
                head.add(matrix[i][j]);
                if(head.size()>k){
                    head.poll();
                }
            }
        }
        return head.peek();
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2},{1,3}};
        int k = 2;
        int kthSmallest1 = kthSmallest(matrix, k);
        System.out.println(kthSmallest1);
        System.out.println(2^1^3);
    }

}
