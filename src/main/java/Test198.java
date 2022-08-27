import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author: yangchao
 * @createTime: 2022-08-25  19:44
 * @description: 最大长方体面积
 */
public class Test198 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        String s = string.substring(1, string.length()-1);
        String[] split = s.split(",");
        int[] ints = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
        int n = ints.length;
        int i = 0, j = n-1;
        int max = -1;
        while(i < j){
            if(ints[i] < ints[j]){
                max = Math.max(max, (j-i)*ints[i]);
                i += 1;
            }else{
                max = Math.max(max, (j-i)*ints[j]);
                j -= 1;
            }
        }
        System.out.println(max);
    }
}
