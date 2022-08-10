import java.util.HashSet;
import java.util.Set;

/**
 * @author: yangchao
 * @createTime: 2022-08-10  08:18
 * @description: 无重复字符的最长子串的长度
 */
public class Test135 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0;
        int right = 0;
        int res = 0;
        Set<Character> set = new HashSet<>();
        while(right < n){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
            }else{
                set.remove(s.charAt(left));
                left++;
            }
            res = Math.max(res, set.size());
        }
        return res;
    }
}
