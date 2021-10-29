package simple;

/**
 * @author Sxuet
 * @program Javasource_leetcode
 * @description 斐波那契数，通常用F（n）表示，形成的序列称为斐波那契数列。该数列由0和1开始，后面的每一项数字都是前面两项数字的和。也就是： F(0) =0,F(1)=1
 *     F（n）=F（n- 1） +F（n-2），其中n>1.给出n，计算F(n)
 * @since 2021-10-29 14:39
 */
public class Fib509 {
  /**
   * 看了眼解题，原来递归只有我这种垃圾写<br>
   * 执行用时： 9 ms , 在所有 Java 提交中击败了 8.07% 的用户 内存消耗： 35.3 MB , 在所有 Java 提交中击败了 17.12% 的用户
   *
   * @param n
   * @return
   */
  public int fib1(int n) {
    if (n == 0) {
      return 0;
    } else if (n == 1) {
      return 1;
    }
    return fib1(n - 1) + fib1(n - 2);
  }

  /**
   * 动态规划dp 使用滚动数组思想把空间复杂度优化为O(1) <br>
   * 时间复杂度：O（n）。空间复杂度：O（1）。
   *
   * @param n
   * @return
   */
  public int fib2(int n) {
    if (n < 2) {
      return n;
    }
    int p = 0, q = 0, r = 1;
    for (int i = 2; i <= n; ++i) {
      p = q;
      q = r;
      r = p + q;
    }
    return r;
  }

  /*
   * leetcode 上还有两种数学解法，一个是矩阵快速幂，一个是通项公式。第二种比较可以理解。
   * 由于涉及到高数，无法被我吸收为自己的通用解法，故不再此处记录。
   */
}
