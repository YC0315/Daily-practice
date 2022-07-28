/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2
 * 返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 */
public class Test24 {
    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "4";
        String res = multiply(num1, num2);
        System.out.println(res);
    }

    private static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        // 保存最终结果
        String res = "";
        for (int i = num2.length() - 1; i >= 0; i--) {
            int temp = 0;
            // 保存num1各位和num2的第i位元素的乘积
            StringBuilder sb = new StringBuilder();

            // 将num2的第i位元素转为数字
            int n2 = num2.charAt(i) - '0';

            // 将num2的不是各位的位置补0
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                sb.append(0);
            }
            // 开始计算num2的第i位元素n2与num1的每一位的乘积
            for (int x = num1.length() - 1; x >= 0 || temp != 0; x--) {
                //  如果num1遍历结束了则补0,此处x可以等于0，x如果没有等于0,则num1的最高位没有参与计算
                int n1 = x >= 0 ? num1.charAt(x) - '0' : 0;
                sb.append((n2 * n1 + temp) % 10);  // 将余数加入字符串
                temp = (n2 * n1 + temp) / 10;  // temp维护的是进位值
            }
            // 此时sb中存放的是num2中的一位元素和num1的乘积，加上num2的上一个元素与num1的乘积
            res = stringSum(res, sb.reverse().toString());
        }
        return res;
    }

    // 两个字符串求和
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
            int x = len1 >= 0 ? s1.charAt(len1) - '0' : 0;
            int y = len2 >= 0 ? s2.charAt(len2) - '0' : 0;
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
