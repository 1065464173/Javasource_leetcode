package simple;

/**
 * @program: Javasource_leetcode
 * @description: 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 *     <p>如果存在一个整数 x 使得n == 2x ，则认为 n 是 2 的幂次方。
 * @author: Sxuet
 * @create: 2021-08-06 10:11
 */
public class IsPowerOfTwo231 {
  // TODO：官方给的位算法和约数都很巧妙。回味～
  /**
   * 自己写的循环，空间复杂度O(n) 遍历一次,时间O(1)
   *
   * <p>执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 35.2 MB , 在所有 Java 提交中击败了 94.42% 的用户
   *
   * @param n
   * @return
   */
  public boolean isPowerOfTwo1(int n) {
    // n<1必不是2的幂次方
    if (n < 1) {
      return false;
    }
    // 循环n/2
    while (n > 1) {
      // 若是2的倍数，>>2
      if (n % 2 == 0) {
        n >>= 1;
      } else {
        return false;
      }
    }
    return true;
  }

  /**
   * n & (n - 1) = 0，那么 n 就是 2 的幂。
   *
   * <p>时间空间都为O(1)
   *
   * @param n
   * @return
   */
  public boolean isPowerOfTwo2(int n) {
    return n > 0 && (n & (n - 1)) == 0;
  }

  /**
   * 其中 −n 是 n 的相反数，是一个负数。该位运算技巧可以直接获取 n 二进制表示的最低位的1 如果 n n 是正整数并且 n
   *
   * <p>n & (-n) = n，那么 n 就是 2 的幂。
   *
   * <p>时间空间都为O(1)
   *
   * @param n
   * @return
   */
  public boolean isPowerOfTwo3(int n) {
    return n > 0 && (n & -n) == n;
  }

  /**
   * 2的最大整数幂为2^30，只需判断n是否是这个数的约数即可
   *
   * <p>时间空间O(1)
   *
   * @param n
   * @return
   */
  public boolean isPowerOfTwo4(int n) {
    final int BIG = 1 << 30;
    return n > 0 && BIG % n == 0;
  }
}
