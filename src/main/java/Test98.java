import java.util.ArrayList;
import java.util.List;

/**
 * @author: yangchao
 * @createTime: 2022-07-27  20:22
 * @description: 括号生成：数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的括号组合。
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 */
public class Test98 {
    // 递归
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        // 创建动态临时字符串
        StringBuilder temp = new StringBuilder();
        dfs(temp, n, n);
        return res;
    }

    public void dfs(StringBuilder temp, int left, int right) {
        // 递归结束条件
        if (left == 0 && right == 0) {
            res.add(temp.toString());
            return;
        }
        // 右括号递归完成后，返回到最后一次左括号的位置
        if (left > 0) {
            temp.append('(');  // 做选择
            dfs(temp, left - 1, right);  // 递归
            temp.deleteCharAt(temp.length() - 1);  // 撤销选择
        }
        if (right > left) {
            temp.append(')');
            dfs(temp, left, right - 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
