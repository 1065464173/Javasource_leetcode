package simple;

import java.math.BigInteger;

/**
 * @program: Javasource_leetcode
 * @description: 给定一个整数 n，返回 n! 结果尾数中零的数量。
 * @author: Sxuet
 * @create: 2021-07-26 21:16
 */
public class TrailingZeroes172 {
  // TODO:很神奇的一道关于因子的数学题，值得背诵！
  /**
   * 自己写的递归，计算阶乘超出时间限制<br>
   * 时间低于O(n^2)
   *
   * @param n
   * @return
   */
  public int trailingZeroes1(int n) {
    // 计算阶乘 防止int越界
    BigInteger nFactorial = BigInteger.ONE;
    for (int i = 2; i <= n; i++) {
      nFactorial = nFactorial.multiply(BigInteger.valueOf(i));
    }
    // Count how many 0's are on the end.
    int zeroCount = 0;
    while (nFactorial.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
      nFactorial = nFactorial.divide(BigInteger.TEN);
      zeroCount++;
    }
    return zeroCount;
  }

  /**
   * 求10 的因子2，5 由于2总比5多，所以只要计算出因子5的个数
   *
   * <p>时间O(n)
   *
   * @param n
   * @return
   */
  public int trailingZeroes2(int n) {
    int zeroCount = 0;
    // 从5开始，每隔一个5，计算因子的个数
    for (int i = 5; i <= n; i += 5) {
      int currentFactor = i;
      // 例如25有两个5因子，所以需要取/5再判断一次
      while (currentFactor % 5 == 0) {
        zeroCount++;
        currentFactor /= 5;
      }
    }
    return zeroCount;
  }

  /**
   * 更高效地计算5因子，详情看解释
   *
   * <p>https://leetcode-cn.com/problems/factorial-trailing-zeroes/solution/xiang-xi-tong-su-de-si-lu-fen-xi-by-windliang-3/
   *
   * <p>时间复杂度O(logn)
   *
   * @param n
   * @return
   */
  public int trailingZeroes3(int n) {
    int zeroCount = 0;
    while (n > 0) {
      n /= 5;
      zeroCount += n;
    }
    return zeroCount;
  }
}
