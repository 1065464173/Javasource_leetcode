package medium;

/**
 * @author Sxuet
 * @program daydayup
 * @description 实现pow（x，n），即计算x的n次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 * @since 2021-11-29 18:21
 */
public class MyPow16 {
  /**
   * 执行用时： 1 ms , 在所有 Java 提交中击败了 30.74% 的用户 内存消耗： 37.9 MB , 在所有 Java 提交中击败了 10.79% 的用户
   *
   * @param x
   * @param n
   * @return
   */
  public double myPow1(double x, int n) {
    if (x == 0) {
      return 0;
    }
    long b = n;
    double res = 1.0;
    if (b < 0) {
      x = 1 / x;
      b = -b;
    }
    while (b > 0) {
      if ((b & 1) == 1) {
        res *= x;
      }
      x *= x;
      b >>= 1;
    }
    return res;
  }

  /**
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 37.3 MB , 在所有 Java 提交中击败了 59.61% 的用户
   *
   * @param x
   * @param n
   * @return
   */
  public double myPow2(double x, int n) {
    if (n == 0) {
      return 1;
    }
    if (n == 1) {
      return x;
    }
    if (n == -1) {
      return 1 / x;
    }
    double p;
    p = myPow2(x, n >> 1);
    if ((n & 1) == 1) {
      return p * p * x;
    } else {
      return p * p;
    }
  }
}
