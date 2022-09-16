import java.util.Scanner;

/**
 * @author: yangchao
 * @createTime: 2022-09-14  14:13
 * @description: TODO
 */
public class Test262 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int res = cal(s);
        System.out.println(res);
    }

    public static int cal(String input) {
        int max = 0;
        int temp = 1;
        if(input == null || input.length() == 0) return 0;
        if(input.length() == 1) return 1;
        for(int i = 1; i < input.length(); ++i){
            char pre = input.charAt(i-1);
            char now = input.charAt(i);
            if(now - pre == 1){
                ++temp;
            }else{
                max = (max > temp? max:temp);
            }
        }
        max = (max>temp?max:temp);
        return max;
    }
}
