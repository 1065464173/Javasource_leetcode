package simple;

/**
 * @author Sxuet
 * @program daydayup
 * @description 写一个函数，输入n，求斐波那契（Fibonacci）数列的第n项（即F（N））。斐波那契数列的定义如下：
 * @since 2021-11-17 19:52
 */
public class Fib10 {
  /**
   * 滑动窗口<br>
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 35 MB , 在所有 Java 提交中击败了 91.83% 的用户
   *
   * @param n
   * @return
   */
  public int fib(int n) {
    final int MOD = 1000000007;
    if (n < 2) {
      return n;
    }
    int p = 0, q = 0, r = 1;

    for (int i = 1; i < n; i++) {
      p = q;
      q = r;
      r = (p + q) % MOD;
    }
    return r;
  }
}
