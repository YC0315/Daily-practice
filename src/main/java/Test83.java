/**
 * @author: yangchao
 * @createTime: 2022-07-21  21:02
 * @description: 判断是否为回文串
 */
public class Test83 {
    public boolean judge (String str) {
        // 使用双指针
        int length = str.length();
        int left = 0;
        int right = length - 1;
        while(left <= right){
            if(str.charAt(left++) != str.charAt(right--)) return false;
        }
        return true;
    }
}
