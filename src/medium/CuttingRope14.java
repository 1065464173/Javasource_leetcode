package medium;

/**
 * @author Sxuet
 * @program daydayup
 * @description
 *     给你一根长度为n的绳子，请把绳子剪成整数长度的m段（m、n都是整数，n》1并且m》1），每段绳子的长度记为k【0】，k【1】...k【m-1】。请问k【0】*k【1】*..
 *     .*k【m-1】可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * @since 2021-12-03 09:40
 */
public class CuttingRope14 {

  /**
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 35.4 MB , 在所有 Java 提交中击败了 11.22% 的用户
   *
   * @param n
   * @return
   */
  public int cuttingRope1(int n) {
    if (n <= 3) return n - 1;
    int a = n / 3, b = n % 3;
    if (b == 0) return (int) Math.pow(3, a);
    if (b == 1) return (int) Math.pow(3, a - 1) * 4;
    return (int) Math.pow(3, a) * 2;
  }

  /**
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 35.1 MB , 在所有 Java 提交中击败了 74.36% 的用户
   *
   * @param n
   * @return
   */
  public int cuttingRope2(int n) {
    if (n == 2) return 1;
    if (n == 3) return 2;
    if (n == 4) return 4;
    int res = 1;
    while (n > 4) {
      res *= 3;
      n -= 3;
    }
    return res * n;
  }
}
