/**
 * @author: yangchao
 * @createTime: 2022-09-18  19:28
 * @description: TODO
 */
public class Test265 {
    public static void main(String[] args) {
        int x = -123;
        int reverse = reverse(x);
        System.out.println(reverse);
    }
    public static int reverse (int x) {
        int flag = 1;
        if(x < 0){
            flag = -1;
            x = -x;
        }
        StringBuilder sb = new StringBuilder();
        while(x != 0){
            int a = x % 10;
            sb.append(a);
            x /= 10;
        }
        Integer value = Integer.valueOf(sb.toString());
        if(value > 65535 || value < -65536) return 0;
        return flag*value;
    }
}
