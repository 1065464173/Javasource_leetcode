package simple;

/**
 * @author Sxuet
 * @program daydayup
 * @description 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为'1'的个数（也被称为汉明重量）.）。 提示：
 *     。请注意，在某些语言（如Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 *     ·在Java中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的示例3中，输入表示有符号整数-3。
 * @since 2021-11-30 09:41
 */
public class HammingWeight15 {
  /**
   * 内置函数 <br>
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 35.4 MB , 在所有 Java 提交中击败了 16.74% 的用户
   */
  public int hammingWeight1(int n) {
    return Integer.bitCount(n);
  }

  /** 遍历数字的二进制位数计算1的个数——超出时间限制 */
  public int hammingWeight2(int n) {
    int ans = 0;
    while (n != 0) {
      if ((n & 1) == 1) {
        ans++;
      }
      n >>= 1;
    }
    return ans;
  }

  /**
   * 循环检查二进制位
   *
   * @param n
   * @return
   */
  public int hammingWeight3(int n) {
    int ret = 0;
    for (int i = 0; i < 32; i++) {
      if ((n & (1 << i)) != 0) {
        ret++;
      }
    }
    return ret;
  }

  /**
   * 位运算优化<br>
   * n & (n−1)，其预算结果恰为把 n 的二进制位中的最低位的 1 变为 0 之后的结果。<br>
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 35.2 MB , 在所有 Java 提交中击败了 68.80% 的用户
   */
  public int hammingWeight(int n) {
    int ret = 0;
    while (n != 0) {
      n &= n - 1;
      ret++;
    }
    return ret;
  }
}
