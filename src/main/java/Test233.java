import java.util.*;

/**
 * @author: yangchao
 * @createTime: 2022-09-02  16:13
 * @description: TODO
 */
public class Test233 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        List<Character> list = new ArrayList<>();
        String s = String.valueOf(a);
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (!list.contains(aChar)) {
                list.add(aChar);
            }
        }
        Collections.reverse(list);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++){
            sb.append(list.get(i));
        }
        System.out.println(Integer.valueOf(sb.toString()));
    }
}
