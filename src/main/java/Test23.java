/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 * <p>
 * 下面就说说为什么字符减'0'可以到相应的整数。现在比如我们要字符‘1’转换成数字1，
 * 而‘1’的对应编码是49的二进制码，但是我们的数字1，就等于1呀，
 * 所以为了由原来的‘1’实际上就是49的二进制变成现在的1对应的二进制1，只好用49-48=1了。
 * 但是在ASCII码里‘0’对应的刚好是48的二进制码，所以我们转换的时候只需要‘1’-‘0’=1；就可以了。
 * 而数字的ASCII码是按顺序规定的。所以其它字符要转换成数字都可以用减‘0’来表示。
 * 大小写字母的转换：先看ASCII码：a~z是97~122的二进制，而A~Z是65~90的二进制编码，于是我们就得出：
 * 大写字母=小写字母-32 ；
 * 这个公式了。当然这里的32我也可以这么写‘Z’=‘z’-'空格'。因为空格的ASCII码是32对应的二进制编码。
 * <p>
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 */
public class Test23 {
    // 可以将字符串进行拆分，然后对应位相加，余数加入最终结果，商加入下一次求和！
    public static void main(String[] args) {
        String s1 = "123";
        String s2 = "11";
        String res = stringSum(s1, s2);
        System.out.println(res);

    }

    private static String stringSum(String s1, String s2) {
        // 创建一个可变字符串对象，用于存放最终结果
        StringBuilder sb = new StringBuilder();
        int len1 = s1.length() - 1;
        int len2 = s2.length() - 1;
        int temp = 0;   //  维护当前是否有进位
        // 此处len可以等于0，因为下标是从长度减一开始的，因此索引为0的字符，也需要参与计算
        while (len1 >= 0 || len2 >= 0 || temp != 0) {  // 此处temp不为0也是筛选条件
            // 你可能会想两个数字位数不同怎么处理，统一在指针当前下标处于负数的时候返回 0
            // 等价于对位数较短的数字进行了补零操作
            int x = len1 >= 0? s1.charAt(len1)-'0':0;
            int y = len2 >= 0? s2.charAt(len2)-'0':0;
            temp = x + y + temp;
            len1--;
            len2--;
            sb.append(temp % 10);  // 将余数放入最终结果
            temp /= 10;  // 将十位上的数用于下次求和，相当于进位
        }
        // 此时sb中是倒序加入的，因此要把sb正序排列
        return sb.reverse().toString();
    }
}
