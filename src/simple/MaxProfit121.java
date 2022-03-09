package simple;

/**
 * @program: Javasource_leetcode
 * @description: 给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
 *     <p>你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *     <p>返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * @author: Sxuet
 * @create: 2021-07-12 20:37
 */
public class MaxProfit121 {
  /**
   * 对于每组 i和j（其中 j>i）我们需要找出 max(prices[j]−prices[i])。
   *
   * <p>暴力解法---超时 时间复杂度O(n 2 )。循环运n(n−1)/2次。 空间复杂度O(1)。只使用了常数个变量。
   *
   * @param prices
   * @return
   */
  public int maxProfit1(int[] prices) {
    int profit = 0;
    for (int i = 0; i < prices.length; i++) {
      for (int j = i + 1; j < prices.length; j++) {
        profit = Math.max(prices[j] - prices[i], profit);
      }
    }
    return profit;
  }

  /**
   * 将每个数组的值与历史最低买入点进行比较，只需要遍历一次即可
   *
   * <p>时间复杂度O(n)，只需要遍历一次。
   *
   * <p>空间复杂度O(1)，只使用了常数个变量。
   *
   * @param prices
   * @return
   */
  public int maxProfit2(int[] prices) {
    int profit = 0;
    int minPrice = prices[0];
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] < minPrice) {
        minPrice = prices[i];
      }
      profit = Math.max(prices[i] - minPrice, profit);
    }
    return profit;
  }
}
