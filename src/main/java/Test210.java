/**
 * @author: yangchao
 * @createTime: 2022-08-28  15:35
 * @description: 股票的最大利润
 */
public class Test210 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int res = 0; // 利润
        int min = prices[0];  // 记录最小值(历史最低价格)，
        // 遍历prices数组
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min) {
                res = Math.max(res, prices[i] - min);
            } else {
                // 不断寻找最小值，最低历史价格
                min = prices[i];
            }
        }
        return res;
    }

    // 或者使用双指针也可以
    public int maxProfit1(int[] prices) {
        if (prices.length < 2)
            return 0;
        int max = 0;
        int left = 0, right = 1;
        int length = prices.length;
        while (right < length) {
            if (prices[left] < prices[right])
                max = Math.max(max, prices[right] - prices[left]);
            else
                left = right;
            right++;
        }
        return max;
    }
}
