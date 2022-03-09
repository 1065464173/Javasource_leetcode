package simple;

/**
 * @program: Javasource_leetcode
 * @description: 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 *     <p>整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 * @author: Sxuet
 * @create: 2021-08-29 22:06
 */
public class IsPowerOfFour342 {
  public static void main(String[] args) {}

  /**
   * 超出时间限制
   *
   * @param n
   * @return
   */
  public boolean isPowerOfFour1(int n) {
    if (n < 0) {
      return false;
    }
    while (n % 4 == 0) {
      n /= 4;
    }
    return n == 1;
  }

  /**
   * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 35.6 MB , 在所有 Java 提交中击败了 8.06% 的用户
   *
   * @param n
   * @return
   */
  public boolean isPowerOfFour2(int n) {
    return Math.log10(n) / Math.log10(4) % 1 == 0;
  }

  /**
   * 如果 n 是 4 的幂，那么 n 一定也是 2 的幂。因此我们可以首先判断 n 是否是 2 的幂，在此基础上再判断 n 是否是 4 的幂。 <br>
   * 内存消耗： 35.3 MB , 在所有 Java 提交中击败了 83.21% 的用户 <br>
   * 时间空间O(1)
   *
   * @param n
   * @return
   */
  public boolean isPowerOfFour3(int n) {
    return n > 0 && (n & (n - 1)) == 0 && (n & 0xaaaaaaaa) == 0;
  }
}
