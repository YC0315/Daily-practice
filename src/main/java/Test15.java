/**
 * 大写字母变小写字母，大写字母和小写字母差32, 大写+32 = 小写
 */
public class Test15 {
    public static void main(String[] args) {
        String s = "HELLo";
        String res = convert(s);
        System.out.println(res);
    }

    private static String convert(String s) {
        if (s == null || ("").equals(s)) {
            return s;
        }
        // StringBuilder线程安全
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {  // 小写转大写则是-32然后再强制转换成char类型
                sb.append((char)(c + 32)); // 字符加数字后是数字，因此要将数字强制转换成字符
            } else {
                sb.append(c);
            }
        }
        return sb.toString();  // StringBuilder类型调用toString()方法转换成String类型
    }
}
