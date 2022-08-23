import java.util.ArrayList;

/**
 * @author: yangchao
 * @createTime: 2022-08-23  14:02
 * @description: TODO
 */
public class Test193 {
    public static void main(String args[]) {
        char c = 'A';
        int num = 5;
        switch (c) {
            case 'B':
                num++;
            case 'A':
                num++;
            case 'Y':
                num++;
                break;
            default:
                num--;
        }
        System.out.println("num = " + num);
}
}
