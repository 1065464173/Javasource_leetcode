package medium;

import javax.imageio.event.IIOWriteProgressListener;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Sxuet
 * @program daydayup
 * @description 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 *     你需要用一个浮点数数组返回答案，其中第i个元素代表这门个骰子所能掷出的点数集合中第i小的那个的概率。
 * @since 2021-12-09 15:21
 */
public class DicesProbability60 {
  /**
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 38.9 MB , 在所有 Java 提交中击败了 5.10% 的用户
   *
   * @param n
   * @return
   */
  public double[] dicesProbability(int n) {
    // 因为最后的结果只与前一个动态转移数组有关，所以这里只需要设置一个一维的动态转移数组
    // 原本dp[i][j]表示的是前i个骰子的点数之和为j的概率，现在只需要最后的状态的数组，所以就只用一个一维数组dp[j]表示n个骰子下每个结果的概率。
    // 初始是1个骰子情况下的点数之和情况，就只有6个结果，所以用dp的初始化的size是6个
    double[] dp = new double[6];
    Arrays.fill(dp, 1.0 / 6.0);
    // 从第2个骰子开始，这里n表示n个骰子，先从第二个的情况算起，然后再逐步求3个、4个···n个的情况
    // i表示当总共i个骰子时的结果
    for (int i = 2; i <= n; i++) {
      // 每次的点数之和范围会有点变化，点数之和的值最大是i*6，最小是i*1，i之前的结果值是不会出现的；
      // 比如i=3个骰子时，最小就是3了，不可能是2和1，所以点数之和的值的个数是6*i-(i-1)，化简：5*i+1
      // 当有i个骰子时的点数之和的值数组先假定是temp
      double[] tmp = new double[5 * i + 1];
      // 从i-1个骰子的点数之和的值数组入手，计算i个骰子的点数之和数组的值
      // 先拿i-1个骰子的点数之和数组的第j个值，它所影响的是i个骰子时的temp[j+k]的值
      for (int j = 0; j < dp.length; j++) {
        for (int k = 0; k < 6; k++) {
          tmp[j + k] += dp[j] / 6.0;
        }
      }
      // i个骰子的点数之和全都算出来后，要将temp数组移交给dp数组，dp数组就会代表i个骰子时的可能出现的点数之和的概率；用于计算i+1个骰子时的点数之和的概率
      dp = tmp;
    }
    return dp;
  }
}
