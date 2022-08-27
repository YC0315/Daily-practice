import java.util.*;
/*
 * @description: 360笔试，可不可以由s串，复制粘贴若干字符得到t串
 * @author: yangchao
 * @date: 2022/8/27 16:42
 * @param:
 * @return:
 **/
public class Test205 {
    public static void main(String[] args) {
        // 针对多行字符串输入的情况
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            // 两个两个的接收，接收完一组后，先进行处理，处理完在接收下一组
            String str1 = scanner.next();
            String str2 = scanner.next();
            String ans = isCheck(str1, str2);
            System.out.println(ans);
        }
    }

    public static String isCheck(String str1, String str2) {
        // s串的长度大于t串的长度
        if (str1.length() > str2.length()) {
            return "NO";
        }
        char[] cs1 = str1.toCharArray();
        char[] cs2 = str2.toCharArray();
        int i1 = 0;
        char c1 = cs1[i1];
        int i2 = 0;
        char c2 = cs2[i2];
        int n1 = 0;
        int n2 = 0;
        while (i1 < cs1.length && i2 < cs2.length) {
            c1 = cs1[i1];
            c2 = cs2[i2];
            // 统计字符串1的各个字母的个数
            while (i1 < cs1.length && c1 == cs1[i1]) {
                i1++;
                n1++;
            } // 统计字符串2的各个字母的个数
            while (i2 < cs2.length && c2 == cs2[i2]) {
                i2++;
                n2++;
            } // 统计的字符不一样或者 字符1的数量大于字符2的数量直接判错
            if (c1 != c2 || n1 > n2) {
                return "NO";
            }
            n1 = 0;
            n2 = 0;
        }
        return i2 >= cs2.length ? "YES" : "NO";  // t串比s串多额外的数字
    }
}