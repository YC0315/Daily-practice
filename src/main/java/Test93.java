/**
 * @author: yangchao
 * @createTime: 2022-07-25  18:16
 * @description: TODO
 */
public class Test93 {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int n = 2;
        process(arr, 0, n);
    }
    static int max = 0;
    private static void process(int[] arr, int index, int n) {
        if(n == 0 || index == arr.length){
            int tmp = 0;
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] == 1){
                    tmp++;
                    max = Math.max(max,tmp);
                }else{
                    tmp = 0;
                }
            }
            return;
        }
        for (int j = index; j < arr.length; j++) {
            if(arr[j] == 0){
                arr[j] = 1;
                process(arr, index+1, n-1);
                arr[j] = 0;
            }
        }
    }
}
