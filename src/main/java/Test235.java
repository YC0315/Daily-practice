import java.util.Scanner;

/**
 * @author: yangchao
 * @createTime: 2022-09-02  16:28
 * @description: TODO
 */
public class Test235 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        String num1 = s[0];
        String num2 = s[1];
        String res = mul(num1, num2);
        System.out.println(res);
    }

    public static String mul(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2)) return "0";
        int m = num1.length(), n = num2.length();
        int[] ans = new int[m+n];
        for(int i = m-1; i>=0; i--){
            int x = num1.charAt(i) -'0';
            for(int j = n-1; j >= 0; j--){
                int y = num2.charAt(j) - '0';
                ans[i+j+1] += x*y;
            }
        }
        for(int i = m+n+1; i>0;i--){
            ans[i-1] += ans[i] / 10;
            ans[i] %= 10;
        }
        int index = ans[0] == 0?1:0;
        StringBuilder res = new StringBuilder();
        while(index < m+n){
            res.append(ans[index++]);
        }
        return res.toString();


    }
}
