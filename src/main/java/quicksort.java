import java.util.Arrays;

// 快速排序,设定基准点，比基准点大的放左边，比基准点小的放右边，然后递归排序左子序列和右子序列
// 快排有两个需要注意的地方，一个是递归出口，一个是基准定为具体的值
public class quicksort {
    public static void main(String[] args) {

        int[] arrs = {1, 3, 5, 2, 2};

        System.out.println("排序前: ");
        System.out.println(Arrays.toString(arrs)); // 调用Arrays.toString()输出数组

        // 进行排序
        mysort(arrs, 0, arrs.length-1);

        System.out.println("排序后: ");
        System.out.println(Arrays.toString(arrs));
    }

    // 排序
    public static void mysort(int[] arrs, int left, int right){

        // 递归出口！
        if(left >= right) return;

        // 定义一个基准！
        // 选定基准,这个基准一定设置成值!!! 不要设置成left索引，因为数组中该索引处的值随着排序会发生变化
        int prior = arrs[left];
        int start = left;
        int end = right;

        while(left < right){
            while(arrs[right] >= prior && left < right){  // 等于基准值也可以不用管，记住这种情况
                right -= 1;
            }
            arrs[left] = arrs[right];
            while(arrs[left] <= prior && left < right){  // 等于基准值也可以不用管，记住这种情况
                left += 1;
            }
            arrs[right] = arrs[left];
        }

        arrs[left] = prior;
        mysort(arrs, start, left-1);
        mysort(arrs, left+1, end);
    }
}
