/**
 *外观数列：
 */
public class Test22 {
    public static String countAndSay(int n) {
        String s = "1";
        for(int i = 2; i <= n; i++){
            StringBuilder sb = new StringBuilder();
            int start = 0;
            int current = 0;
            while(current < s.length()){
                // 右指针一直往右走，同时检查是否等于第一次出现时的值
                while(current < s.length() && s.charAt(current) == s.charAt(start)){
                    current++;
                }
                sb.append(String.valueOf(current-start)).append(s.charAt(start));
                start = current;
            }
            // for循环每循环一次，字符串s就换成了上一次更新后的值
            s = sb.toString();
        }
        return s;
    }


    public static void main(String[] args) {
        String s = countAndSay(4);
        System.out.println(s);
    }
}
