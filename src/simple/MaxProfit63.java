package simple;

/**
 * @author Sxuet
 * @program daydayup
 * @description 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * @since 2021-11-17 20:23
 */
public class MaxProfit63 {
  /**
   * 执行用时： 1 ms , 在所有 Java 提交中击败了 98.78% 的用户 内存消耗： 38 MB , 在所有 Java 提交中击败了 76.85% 的用户
   *
   * @param prices
   * @return
   */
  public int maxProfit(int[] prices) {
    int minprice = Integer.MAX_VALUE;
    int profit = 0;
    for (int i = 0; i < prices.length; i++) {
      minprice = Math.min(minprice, prices[i]);
      profit = Math.max(prices[i] - minprice, profit);
    }
    return profit;
  }
}
