/**
 * @author: yangchao
 * @createTime: 2022-07-22  09:14
 * @description: 最长回文子串，返回子串，不是长度
 */
public class Test86 {
    // 使用动态规划，在回文子串的题目上稍微扩展得到
    public String longestPalindrome(String s) {
        int n = s.length()-1;
        int left = 0;
        int right = 0;
        boolean[][] dp = new boolean[n+1][n+1];
        for(int i=n;i>=0;i--){
            for(int j=i;j<=n;j++){
                if(s.charAt(i) == s.charAt(j) && (j-i<=2||dp[i+1][j-1])){
                    dp[i][j] = true;
                    if((j-i+1)>(right-left)){
                        left = i;
                        right = j;
                    }
                }
            }
        }
        return s.substring(left,right+1);
    }

    // 使用中心拓展法，在回文子串题目上拓展得到
    int left = 0;
    int right = 0;
    public String longestPalindrome1(String s) {
        //中心拓展法
        int n = s.length() - 1;
        for (int i = 0; i <= n; i++) {
            count1(s, i, i);
            count1(s, i, i + 1);
        }
        return s.substring(left, right + 1);
    }
    private void count1(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            if((end-start+1)>(right-left+1)){
                left = start;
                right = end;
            }
            start--;
            end++;
        }
    }
}
