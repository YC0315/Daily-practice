import java.util.*;
/**
 * @author: yangchao
 * @createTime: 2022-08-27  18:50
 * @description: TODO
 */
public class Test206 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        char[] chars = sc.nextLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++){
            chars[i] &= -33;
            sb.append(chars[i]);
        }
        for(int j = m; j < chars.length; j++){
            chars[j] |= 32;
            sb.append(chars[j]);
        }
        System.out.println(sb.toString());

    }


}
