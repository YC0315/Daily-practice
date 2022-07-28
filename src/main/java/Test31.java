
/**
 * @author: yangchao
 * @createTime: 2022-06-29  20:50
 * @description: 将字符串转换成int型
 */
/*
根据题意，有以下四种字符需要考虑：
1. 首部空格： 删除之即可；
2. 符号位： 三种情况，即 ''+'' , ''−'' , ''无符号" ；新建一个变量保存符号位，返回前判断正负即可。
3. 非数字字符： 遇到首个非数字的字符时，应立即返回。
4. 数字字符：
   字符转数字： 此数字字符'x'的 ASCII 码与'0'的 ASCII 码相减即可；
   数字拼接： 若从左向右遍历数字，设当前位字符为 c ，当前位数字为 x ，数字结果为 res ，则数字拼接公式为：
        res=10×res+x
        x=ascii('c')−ascii(′0′)
5. 数字越界处理：
在每轮数字拼接前，判断 res 在此轮拼接后是否超过 2147483647，若超过则加上符号位直接返回。
设数字拼接边界 bndry = 2147483647 // 10 = 214748364，则以下两种情况越界：
    res > bndry           情况一：执行拼接 10 * res >= 2147483650 越界
    res = bndry && x > 7  情况二：拼接后是 2147483648 或 2147483649 越界
*/
public class Test31 {
    public static void main(String[] args) {
        String str = "+-2";
        int toInt = strToInt(str);
        System.out.println(toInt);
    }

    public static int strToInt(String str) {
        // trim()去除字符串前后空格!!
        char[] chars = str.trim().toCharArray();
        if (chars.length == 0) {
            return 0;
        }
        int res = 0; // 拼接数字时使用，作为十分位,并存放最终拼接的结果res = res * 10 + c
        int boundry = Integer.MAX_VALUE / 10;  // 边界为整型最大值对10取余，因为要拼接数组，要乘10，因此边界不能使用整形最大值
        int flag = 1; // 正负号的标识
        int i = 1;  // for循环开始遍历字符的起始位置
        if (chars[0] == '-') {
            flag = -1;
        } else if (chars[0] != '+') {
            i = 0;  // 假如第一位不为+-号，即无符号，则从第0位开始遍历字符串
        }
        for (int j = i; j < chars.length; j++) {
            // 如果不是数字符号开头
            if (chars[j] < '0' || chars[j] > '9') {
                break;
            }
            // 如果越界
            if (res > boundry || (res == boundry && chars[j] > '7')) {
                return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;  // 看符号位是正是负
            }
            // 如果数字开头而且res不越界,拼接数字字符，前一项乘10加上后一项！！
            res = res * 10 + (chars[j] - '0');
        }
        return flag * res;
    }
}
