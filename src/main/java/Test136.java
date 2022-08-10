/**
 * @author: yangchao
 * @createTime: 2022-08-10  19:02
 * @description: 回文数
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 */
public class Test136 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String s = String.valueOf(x);
        int n = s.length();
        int left = 0;
        int right = n - 1;
        while(left != right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
