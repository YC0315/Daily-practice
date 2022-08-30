/**
 * @author: yangchao
 * @createTime: 2022-08-29  14:08
 * @description: 买卖股票的最佳时机
 */
public class Test211 {
    public int maxProfit(int[] prices) {
        int min = prices[0]; // 维护一个最小值
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > min) {
                maxProfit = Math.max(maxProfit, prices[i] - min);
            } else {
                min = prices[i];
            }
        }
        return maxProfit;
    }

}
