import java.util.*;

/**
 * @author: yangchao
 * @createTime: 2022-07-25  21:05
 * @description: 字符串的全排列，具有重复字符
 * 针对排列问题，就是做选择的过程，我们需要进行n次选择，每次需要记录选择的数据且不能重复选择，具体过程如下：
 *      1.遍历字符串中的字符，选择一个下标未加入过的字符（因为有重复不能比较字符值）加入记录中；
 *      2.重复1过程，直到字符串中的字符都加入到了记录中；
 *      3.撤销上一次的选择，选择上一次选择的下一个字符，并重复1,2；
 *      4.直到上一次选择的下一个字符为空，选择过程结束
 *      输入："abc"
 *      返回值：["abc","acb","bac","bca","cab","cba"]
 */
public class Test94 {
    // 字符串的全排列，使用回溯加记录的方式
    static ArrayList<String> res = new ArrayList<>();
    public ArrayList<String> Permutation (String str) {
        if(str == null || str.length() == 0) return res;
        char[] chars = str.toCharArray();
        // 对数组进行排序
        Arrays.sort(chars);
        // 存储临时字符串
        StringBuilder sb = new StringBuilder();
        // 因为有重复元素，因此不能使用比较值的方式确定当前值是否已经使用，使用一个map记录下标和元素值
        // 来表示当前值是否被使用过
        Map<Integer, Character> map = new HashMap<>();
        backtrace(chars, sb, map);
        return res;
    }

    private void backtrace(char[] chars, StringBuilder sb, Map<Integer, Character> map) {
        if(sb.length() == chars.length){
            // 将sb添加到最终集合中，但是不能有重复元素，因此要先去重
            if(!res.contains(sb.toString())){
                res.add(sb.toString());
            }
            return;
        }
        // 做选择
        for (int i = 0; i < chars.length; i++) {
            // 先检查当前元素有没有被使用过
            if(map.containsKey(i)){
                continue;
            }
            // 没有使用过当前元素,添加选择
            sb.append(chars[i]);
            map.put(i, chars[i]);
            // 回溯
            backtrace(chars, sb, map);
            // 撤销最后一次的选择
            sb.deleteCharAt(sb.length()-1);
            map.remove(i);
        }
    }

    // 使用和无重复元素的全排列一样的做法
    // 字符串的全排列，使用回溯加记录的方式
    ArrayList<String> res1 = new ArrayList<>();
    public ArrayList<String> Permutation1 (String str) {
        if(str == null || str.length() == 0) return res1;
        char[] chars = str.toCharArray();
        boolean[] vis = new boolean[chars.length];
        // 对数组进行排序
        Arrays.sort(chars);
        // 存储临时字符串
        StringBuilder sb = new StringBuilder();
        backtrace1(chars, sb, vis, 0);
        return res1;
    }

    public void backtrace1(char[] chars, StringBuilder sb, boolean[] vis, int index) {
        if(sb.length() == chars.length){
            // 将sb添加到最终集合中，但是不能有重复元素，因此要先去重
            if(index == chars.length){
                res1.add(sb.toString());
            }
            return;
        }
        // 做选择
        char prev = '1';
        for (int i = 0; i < chars.length; i++) {
            // 先检查当前元素有没有被使用过
            if(vis[i] || prev == chars[i]) continue;
            prev = chars[i];
            // 没有使用过当前元素,添加选择
            sb.append(chars[i]);
            vis[i] = true;
            // 回溯
            backtrace1(chars, sb, vis, index+1);
            // 撤销最后一次的选择
            vis[i] = false;
            sb.deleteCharAt(sb.length()-1);
        }
    }


}
