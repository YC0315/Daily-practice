import java.util.Scanner;

/**
 * @author: yangchao
 * @createTime: 2022-09-02  16:25
 * @description: TODO
 */
public class Test234 {
    public static void main(String[] args) {
        int a, b, c;
        Scanner reader = new Scanner(System.in);
        a = reader.nextInt();
        b = reader.nextInt();
        c = reader.nextInt();
        if((a+b)> c && (a+c) > b && (b+c)>a){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}
