package simple;

/**
 * @program: Javasource_leetcode
 * @description: 给定一个整数，写一个函数来判断它是否是 3的幂次方。如果是，返回 true ；否则，返回 false 。
 *     <p>整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 * @author: Sxuet
 * @create: 2021-08-27 22:48
 */
public class IsPowerOfThree326 {

  /**
   * 自创循环迭代写法。<br>
   * 执行用时： 15 ms , 在所有 Java 提交中击败了 93.96% 的用户 内存消耗： 38.4 MB , 在所有 Java 提交中击败了 19.25% 的用户
   *
   * @param n
   * @return
   */
  public boolean isPowerOfThree1(int n) {
    if (n == 0) {
      return false;
    }
    while (n != 1) {
      if (n % 3 != 0) {
        return false;
      }
      n /= 3;
    }
    return true;
  }

  /**
   * 官方循环递归 时间O(logb(n)) 空间O(1) <br>
   * 执行用时： 15 ms , 在所有 Java 提交中击败了 93.96% 的用户 内存消耗： 38.3 MB , 在所有 Java 提交中击败了 42.22% 的用户
   *
   * @param n
   * @return
   */
  public boolean isPowerOfThree2(int n) {
    if (n < 1) {
      return false;
    }
    while (n % 3 == 0) {
      n /= 3;
    }
    return n == 1;
  }

  /**
   * 基准转换 涉及到从3为低转换为10为底的公式
   *
   * <p>我们所要做的就是将数字转换为以3为底的基数 ，并检查它是否为前导1，后跟所有 0。<br>
   * 两个内置的Java函数将帮助我们前进
   *
   * <p>时间 空间 都是 O(log3(n)<br>
   * 执行用时： 32 ms , 在所有 Java 提交中击败了 5.02% 的用户 内存消耗： 38.4 MB , 在所有 Java 提交中击败了 15.45% 的用户
   *
   * @param n
   * @return
   */
  public boolean isPowerOfThree3(int n) {
    // 看不太懂，执行的效果也不咋地。看着是牛逼
    return Integer.toString(n, 3).matches("^10*$");
  }

  /**
   * 运算法 %1 判断是不是整数并检查是否是0<br>
   *
   * <p>n=3^i i=log3(n)=log10(n)/log10(3) <br>
   * 执行用时： 15 ms , 在所有 Java 提交中击败了 93.96% 的用户 内存消耗： 38.1 MB , 在所有 Java 提交中击败了 72.43% 的用户
   *
   * @param n
   * @return
   */
  public boolean isPowerOfThree4(int n) {
    return Math.log10(n) / Math.log10(3) % 1 == 0;
    // 但是Math方法的log需要传入double。会遇到精度错误。为了解决问题，需要将结果与epsilon进行比较
    // return (Math.log(n) / Math.log(3) + EPSILON) % 1 <= 2 * EPSILON;
  }

  /**
   * 整数限制
   *
   * <p>由于题目限制。n为int类型，最大值2147483647<br>
   * 所以n是三的幂的最大值是1162261467也就是3^19 <br>
   * 我们应该返回 true 的 n 的可能值是3的0次幂到19次幂。因为 3 是质数，所以 3^19 的除数只有3的0次幂到19次幂.<br>
   * 因此我们只需要将 3^19 除以 n。若余数为 0 意味着n是 3 的幂。
   *
   * <p>时间复杂度O(1) 空间O(1) <br>
   * 执行用时： 15 ms , 在所有 Java 提交中击败了 93.96% 的用户 内存消耗： 38.2 MB , 在所有 Java 提交中击败了 60.30% 的用户
   *
   * @param n
   * @return
   */
  public boolean isPowerOfThree5(int n) {
    // TODO：UNBELIEVABLE！
    return n > 0 && 1162261467 % n == 0;
  }
}
