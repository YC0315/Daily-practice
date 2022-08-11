/**
 * @author: yangchao
 * @createTime: 2022-08-11  19:46
 * @description: Z字形变换
 */
public class Test144 {
    public String convert(String s, int numRows) {
        // 假如要求最后输出一行则不用拆分字符串，或者字符串的个数小于要求拆分的行数
        // 即只有一行或者只有一列的情况直接返回
        if(numRows == 1 || s.length() <= numRows) return s;
        // 创建一个字符串数组，里面包含numRows个动态字符串
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder(); // 每一个字符数组元素都是一个动态字符串
        }
        int flag = 1;  // 定义一个转向标志
        int index = 0; // index表示行数
        for (int i = 0; i < s.length(); i++) {
            sb[index].append(s.charAt(i));
            index= index + flag;  // 行数加转向的标志来控制向哪个动态字符串内添加字符
            // 变换方向
            if (index == numRows - 1 || index == 0) {
                flag = -flag;
            }
        }
        // 合并动态字符串数组
        StringBuilder ss = new StringBuilder();
        for (StringBuilder t : sb) {
            ss.append(t);  // 直接添加到一个动态字符串上即可
        }
        return ss.toString();
    }
}
