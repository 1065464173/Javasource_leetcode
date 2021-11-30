package simple;

/**
 * @author Sxuet
 * @program daydayup
 * @description 写一个函数，求两个整数之和，要求在函数体内不得使用“+”、“”“米”“”四则运算符号。
 * @since 2021-11-30 09:50
 */
public class Add65 {
  /**
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 35.3 MB , 在所有 Java 提交中击败了 13.10% 的用户
   *
   * @param a
   * @param b
   * @return
   */
  public int add1(int a, int b) {
    // 当进位为 0 时跳出
    while (b != 0) {
      // c = 进位
      int c = (a & b) << 1;
      // a = 非进位和
      a ^= b;
      // b = 进位
      b = c;
    }
    return a;
  }

  /**
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 35.3 MB , 在所有 Java 提交中击败了 27.81% 的用户
   *
   * @param a
   * @param b
   * @return
   */
  public int add2(int a, int b) {
    if (b == 0) {
      return a;
    }

    // 转换成非进位和 + 进位
    return add2(a ^ b, (a & b) << 1);
  }
}
