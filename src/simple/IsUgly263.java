package simple;

/**
 * @program: Javasource_leetcode
 * @description: 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
 *     <p>丑数 就是只包含质因数2、3 和/或5的正整数。
 * @author: Sxuet
 * @create: 2021-08-17 13:26
 */
public class IsUgly263 {
  /**
   * 当 n>0 时，若 n 是丑数，则 n 可以写成 n=2 a ×3 b ×5 c 的形式，其中 a,b,c 都是非负整数。特别地，当 a,b,c 都是 0 时 n=1。
   *
   * <p>为判断 n 是否满足上述形式，可以对 n 反复除以 2,3,5，直到 n 不再包含质因数 2,3,5。若剩下的数等于 1，则说明 n 不包含其他质因数，是丑数；否则，说明 n
   * 包含其他质因数，不是丑数。
   *
   * <p>时间负责度O(logn) 空间O(1)
   *
   * @param n
   * @return
   */
  public boolean isUgly(int n) {
    if (n < 1) {
      return false;
    }
    int[] factors = {2, 3, 5};
    for (int factor : factors) {
      while (n % factor == 0) {
        n /= factor;
      }
    }
    return n == 1;
  }
}
