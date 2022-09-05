/**
 * @author: yangchao
 * @createTime: 2022-09-02  18:49
 * @description: TODO
 */
public class Test236 {
    public static void main(String[] args) {
        String str = "Hello world";
        String mod = "l*o";
        int str1 = findStr(str, mod);
        System.out.println(str1);
    }

    public static int findStr(String str, String mod) {
        char[] chars = mod.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        String mod1 = sb.toString();

        // 使用双指针
        int left = 0;
        int right = 0;
        while (left < str.length() && right < mod1.length()) {
            while (right < mod1.length() && mod1.charAt(right) == '*') {
                right++;
            }
            if (str.charAt(left) == mod1.charAt(right) && right != mod1.length() - 1) {
                right++;
                while (mod1.charAt(right) == '*') {
                    right++;
                    if (right >= mod1.length()) return left;
                }
            } else if (str.charAt(left) == mod1.charAt(right) && right == mod1.length() - 1) {
                break;
            }
            left++;
        }
        return right < mod1.length() - 1 ? -1 : left;
    }
}
