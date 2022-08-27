import java.util.*;

/**
 * @author: yangchao
 * @createTime: 2022-08-27  14:45
 * @description: TODO
 */
public class Test204 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        List<String> strings = new ArrayList<>();
        for(int i = 0; i < 2 * T; i++){
            String s = sc.nextLine();
            strings.add(s);
        }
        int l = 0;
        while(l <= 2*T-1){
            int r = l + 1;
            String s1 = strings.get(l);
            String s2 = strings.get(r);

            Set<Character> set1 = new HashSet<>();
            for (char c : s1.toCharArray()) {
                set1.add(c);
            }
            Set<Character> set2 = new HashSet<>();
            for (char c : s2.toCharArray()) {
                set2.add(c);
            }
            int a = set1.size();
            int b = set2.size();
            if(a != b){
                System.out.println("NO");
            }else{
                char[] c1 = new char[a];
                char[] c2 = new char[a];
                int i = 0, j = 0;
                for (Character character : set1) {
                    c1[i++] = character;
                }
                for (Character character : set2) {
                    c2[j++] = character;
                }
                for(int n = 1; n< a; n++){
                    if(c1[n] != c2[n]){
                        System.out.println("NO");
                        break;
                    }
                    if(n == a-1){
                        System.out.println("YES");
                    }
                }
            }
            l += 2;
        }
    }
}
