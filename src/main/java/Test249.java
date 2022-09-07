import java.util.*;

/**
 * @author: yangchao
 * @createTime: 2022-09-07  14:34
 * @description: TODO
 */
public class Test249 {
    public int timeRequiredToBuyCounpons(int[] coupons, int m) {
        int len = coupons.length;
        int count = 0;
        while (coupons[m] != 0) {
            for (int i = 0; i < len; i++) {
                if(coupons[m] == 0) break;
                if (coupons[i] != 0) {
                    coupons[i]--;
                    count++;
                }
            }
        }
        return count * 10;
    }
}
