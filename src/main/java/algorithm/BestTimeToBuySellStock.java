package algorithm;

/**
 * @author lancelot
 * @date 2020/3/14
 * @description leetcode [121]
 */
public class BestTimeToBuySellStock {

    public static int maxProfit(int[] prices) {
        int profit = 0;
        if (prices.length == 0) return profit;
        int buy = prices[0];
        for (int i = 0; i < prices.length; i++) {
//            if (buy > prices[i]) {
//                buy = prices[i];
//            }
            buy = Math.min(buy, prices[i]);
            profit = Math.max(profit, prices[i] - buy);
        }
        return profit;
    }


    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
}
