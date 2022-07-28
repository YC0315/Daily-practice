import java.util.Arrays;

// 冒泡排序:依次将最大值浮动到末尾，每次检查时不再检查最后一个值的大小
public class maopaosort {
    public static void main(String[] args) {

        int[] arrs = {10, 17, 50, 7, 30, 24, 27, 45, 15, 5, 36, 21};

        System.out.println("排序前: ");
        System.out.println(Arrays.toString(arrs)); // 调用Arrays.toString()输出数组

        // 进行排序
        maopao(arrs);

        System.out.println("排序后: ");
        System.out.println(Arrays.toString(arrs));

    }

    // 排序
    private static void maopao(int[] arrs) {
        int temp = 0;
        for(int i=0; i < arrs.length; i++){
            for(int j=0; j < arrs.length-1-i; j++){
                if(arrs[j] > arrs[j+1]){
                    temp = arrs[j];
                    arrs[j] = arrs[j+1];
                    arrs[j+1] = temp;
                }
            }
        }
    }
}