package algorithm.dp;

/**
 * @author lancelot
 * @date 2020/3/14
 * @description leetcode [121] 买卖股票的最佳时机 & 剑指 Offer 63. 股票的最大利润
 * @difficulty Easy
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * 注意：你不能在买入股票前卖出股票。
 *
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 *
 * 示例 2:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 链接：https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof
 */
public class BestTimeToBuySellStock {

    /**
     * 交易一次（k = 1）
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int profit = 0;
        if (prices.length == 0) return profit;
        int buy = prices[0];
        for (int i = 0; i < prices.length; i++) {
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
