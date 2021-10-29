package simple;

/**
 * @author Sxuet
 * @program Javasource_leetcode
 * @description 对于一个正整数，如果它和除了它自身以外的所有正因子之和相等，我们称它为「完美数」。 给定一个整数n，如果是完美数，返回true，否则返回false
 * @since 2021-10-29 14:02
 */
public class CheckPerfectNumber507 {
  /**
   * 暴力解法-<br>
   * 执行用时： 2115 ms , 在所有 Java 提交中击败了 21.91% 的用户 内存消耗： 35.2 MB , 在所有 Java 提交中击败了 39.91% 的用户
   *
   * @param num
   * @return
   */
  public boolean checkPerfectNumber1(int num) {
    int sum = 0;
    for (int i = 1; i < num; i++) {
      if (num % i == 0) {
        sum += i;
      }
    }
    return sum == num;
  }

  /**
   * 枚举所有1-sqr(n)的引述<br>
   * 执行用时： 1 ms , 在所有 Java 提交中击败了 90.55% 的用户 内存消耗： 35.2 MB , 在所有 Java 提交中击败了 54.18% 的用户
   *
   * @param num
   * @return
   */
  public boolean checkPerfectNumber2(int num) {
    int sum = 0;
    for (int i = 1; i * i < num; i++) {
      if (num % i == 0) {
        sum += (num / i + i);
      }
    }
    return sum == num * 2;
  }

  /**
   * 数学方式：欧几里得-欧拉定理——每个偶数是完全数都可以写成(2^(P一1))*(2^P-1) <br>
   * (2^P-1)中的p称为梅森素数。目前奇完全数还未被发现， <br>
   * 时间O(1) 空间O(1)
   *
   * <p>执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 35.1 MB , 在所有 Java 提交中击败了 63.27% 的用户
   *
   * @param num
   * @return
   */
  public boolean checkPerfectNumber3(int num) {
    int[] primes = new int[] {2, 3, 5, 7, 13, 17, 19, 31};
    for (int p : primes) {
      if ((1 << (p - 1)) * ((1 << p) - 1) == num) {
        return true;
      }
    }
    return false;
  }
}
