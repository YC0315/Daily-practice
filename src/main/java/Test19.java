/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 *
 * 可以用横向比较方式也可以用纵向比较方式，或者使用现成的Api
 */
public class Test19 {
    public static void main(String[] args) {
        String[] str = {"dog","racecar","cars"};
        String res = lengthestPre(str);
        System.out.println(res);
    }
    private static String lengthestPre(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        String s = strs[0];
        for (String str : strs) {
            while(!str.startsWith(s)){  // startsWith()用于检查字符串str是否以s字符串开头，返回值为boolean类型
                if(str.length() == 0){
                    return "";
                }
                s = s.substring(0, s.length()-1);
            }
        }
        return s;
    }

}
