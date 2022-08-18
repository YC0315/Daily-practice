import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author: yangchao
 * @createTime: 2022-08-17  22:10
 * @description: 分析多线程打印日志
 */
public class Test177 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        // 使用双端队列
        LinkedList<LinkedList<Character>> res = new LinkedList<>();
        char[] arr = line.toCharArray(); // 将输入的字符串转换成字符数组[faifleadiled]
        String failed = "failed";
        for (char ch : arr) {
            if (ch == 'f') {
                boolean flag = false;
                for (LinkedList<Character> list : res) {
                    if (list.size() == 0) {
                        list.offerLast(ch);
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    LinkedList<Character> list = new LinkedList<>();
                    list.add(ch);
                    res.offerLast(list);
                }
            } else if (ch == 'd') {
                boolean flag = false;
                for (LinkedList<Character> list : res) {
                    if (list.size() == failed.length() - 1) {
                        list.clear();
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    System.out.println(-1);
                    return;
                }
            } else {
                int index = failed.indexOf(ch);  // 1
                boolean flag = false;
                for (LinkedList<Character> list : res) {
                    if (list.size() == index) {
                        list.add(ch);
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        int count = 0;
        for (LinkedList<Character> list : res) {
            if (list.size() == 0) {
                count++;
            }
        }
        if (count == res.size()) {
            System.out.println(count);
            return;
        }
        System.out.println(-1);
    }
}
