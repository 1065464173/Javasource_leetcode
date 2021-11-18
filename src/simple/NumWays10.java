package simple;

/**
 * @author Sxuet
 * @program daydayup
 * @description 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *     答案需要取模1e9+7（1000000007），如计算初始结果为：1000000008，请返回1。
 * @since 2021-11-17 20:07
 */
public class NumWays10 {
  /**
   * 可以转换为<br>
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 35.2 MB , 在所有 Java 提交中击败了 48.51% 的用户
   *
   * @param n
   * @return
   */
  public int numWays1(int n) {
    final int MOD = 1000000007;
    if (n < 2) {
      return 1;
    }
    int p = 1, q = 1, r = 2;

    for (int i = 1; i < n; i++) {
      p = q;
      q = r;
      r = (p + q) % MOD;
    }
    return r;
  }

  /**
   * 精选答案 比我的更简洁， 我的是参考了 上一题 Fib10
   *
   * @param n
   * @return
   */
  public int numWays2(int n) {
    int a = 1, b = 1, sum;
    for (int i = 0; i < n; i++) {
      sum = (a + b) % 1000000007;
      a = b;
      b = sum;
    }
    return a;
  }
}
