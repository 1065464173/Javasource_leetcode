package simple;

/**
 * @program: Javasource_leetcode
 * @description: 给定一个数组 prices ，其中prices[i] 是一支给定股票第 i 天的价格。
 *     <p>设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *     <p>注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * @author: Sxuet
 * @create: 2021-07-13 17:10
 */
public class MaxProfitII122 {
  /**
   * 贪心算法
   *
   * <p>时间复杂符O(n) 只遍历一次
   *
   * <p>空间复杂度O(1)
   *
   * @param prices
   * @return
   */
  public int maxProfit1(int[] prices) {
    int profit = 0;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i - 1] < prices[i]) {
        profit += prices[i] - prices[i - 1];
      }
    }
    return profit;
  }

  /**
   * 动态规划定义状态 dp[i][0] 表示第i 天交易完后手里没有股票的最大利润dp[i][1] 表示第i 天交易完后手里持有一支股票的最大利润
   *
   * <p>dp[i][0]=max{dp[i−1][0],dp[i−1][1]+prices[i]}
   *
   * <p>dp[i][1]=max{dp[i−1][1],dp[i−1][0]−prices[i]}
   *
   * <p>时间复杂度O(n)
   *
   * <p>空间复杂度O(n)
   *
   * @param prices
   * @return
   */
  public int maxProfit2(int[] prices) {
    int n = prices.length;
    int[][] dp = new int[n][2];
    dp[0][0] = 0;
    dp[0][1] = -prices[0];
    for (int i = 1; i < n; i++) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
    }
    return dp[n - 1][0];
  }

  /**
   * 优化maxProfit2的动态规划, 将上述方法的空间复杂度降到O(1)
   *
   * <p>由于每天的状态都只与前一天有关，所以只需要维护每天的两个遍历即可-正在交易/不在交易的状态
   *
   * @param prices
   * @return
   */
  public int maxProfit3(int[] prices) {
    int dp0 = 0;
    int dp1 = -prices[0];
    for (int i = 0; i < prices.length; i++) {
      dp0 = Math.max(dp0, dp1 + prices[i]);
      dp1 = Math.max(dp1, dp0 - prices[i]);
    }
    return dp0;
  }
}
