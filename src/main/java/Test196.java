import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: yangchao
 * @createTime: 2022-08-24  20:18
 * @description: 接雨水：给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class Test196 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ints = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int trap = trap(ints);
        System.out.println(trap);
    }

    // 使用遍历的方式
    public static int trap(int[] height) {
        // 木桶效应，找到最高的点，然后从最高点，向左右扩散
        // 找到最高点，分别从最左边和最右边想最高点遍历，当前值小于上一个值，即可以接到雨水
        // 返回最终结果
        int res = 0;
        // 先遍历找到最大值
        int maxIndex = 0;
        for (int i = 0; i < height.length; i++) {
            if(height[i] > height[maxIndex]){
                maxIndex = i;
            }
        }

        // 从左边开始寻找至最大值索引处
        int temp1 = 0;
        for (int i = 1; i <= maxIndex; i++) {
            if(height[i] > height[temp1]){
                // 右边大于左边，不能存水,这块不是temp++,而是直接跨越到下一个比它高的位置！！
                height[temp1] = height[i];
            }else{
                res += (height[temp1]-height[i]);
            }
        }

        // 从右边开始寻找至最大值索引处
        int temp2 = height.length-1;
        for(int j = height.length-1; j >= maxIndex; j--){
            if(height[j] > height[temp2]){
                // 左边大于右边，不能存水,这块不是temp++,而是直接跨越到下一个比它高的位置！！
                height[temp2] = height[j];
            }else{
                res += (height[temp2]-height[j]);
            }
        }
        return res;
    }
}
