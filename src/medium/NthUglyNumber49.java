package medium;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Sxuet
 * @program daydayup
 * @description 我们把只包含质因子2、3和5的数称作丑数（Ugly Number）。求按从小到大的顺序的第n个丑数。
 * @since 2021-12-08 21:17
 */
public class NthUglyNumber49 {
  /**
   * 最小堆 依次存放2x,3x,5x
   * @param n
   * @return
   */
  public int nthUglyNumber1(int n) {
    int[] factors = {2, 3, 5};
    Set<Long> seen = new HashSet<>();
    PriorityQueue<Long> heap = new PriorityQueue<>();
    seen.add(1L);
    heap.offer(1L);
    int ugly = 0;
    for (int i = 0; i < n; i++) {
      long curr = heap.poll();
      ugly = (int) curr;
      for (int factor : factors) {
        long next = curr * factor;
        if (seen.add(next)) {
          heap.offer(next);
        }
      }
    }
    return ugly;
  }

  /**
   * 执行用时： 3 ms , 在所有 Java 提交中击败了 28.13% 的用户 内存消耗： 37.6 MB , 在所有 Java 提交中击败了 35.34% 的用户
   *
   * @param n
   * @return
   */
  public int nthUglyNumber2(int n) {
    int[] dp = new int[n + 1];
    dp[1] = 1;
    int p2 = 1, p3 = 1, p5 = 1;
    for (int i = 2; i <= n; i++) {
      int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
      dp[i] = Math.min(Math.min(num2, num3), num5);
      if (dp[i] == num2) {
        p2++;
      }
      if (dp[i] == num3) {
        p3++;
      }
      if (dp[i] == num5) {
        p5++;
      }
    }
    return dp[n];
  }

}
