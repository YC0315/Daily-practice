import java.util.ArrayList;
import java.util.List;

/**
 * @author: yangchao
 * @createTime: 2022-08-28  14:43
 * @description: 判断m~n之间的素数
 */
public class Test209 {
    ArrayList<Integer> res = new ArrayList<>();

    public ArrayList<Integer> findPrimeNumber(int m, int n) {
        for (int i = m; i <= n; i++) {
            if (a(i)) {
                res.add(i);
            }
        }
        return res;
    }

    public boolean a(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
