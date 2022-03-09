package simple;

/**
 * @program: Javasource_leetcode
 * @description: 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。 给你两个整数x和y，计算并返回它们之间的汉明距离。
 * @author: Sxuet
 * @create: 2021-10-12 10:52
 */
public class HammingDistance461 {
  /**
   * 通过异或运算后计算结果的二进制1的个数即可 <br>
   * 这里计算1 的方式是用jdk自带的bitCount方法
   *
   * <p>执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 34.9 MB , 在所有 Java 提交中击败了 97.67% 的用户
   *
   * @param x
   * @param y
   * @return
   */
  public int hammingDistance1(int x, int y) {
    return Integer.bitCount(x ^ y);
  }

  /**
   * 同样的异或操作，使用Brian Kernighan 算法实现1的计算 <br>
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 35.3 MB , 在所有 Java 提交中击败了 17.84% 的用户
   *
   * @param x
   * @param y
   * @return
   */
  public int hammingDistance2(int x, int y) {
    int s = x ^ y, ret = 0;
    while (s != 0) {
      s &= s - 1;
      ret++;
    }
    return ret;
  }
}
