package simple;

/**
 * @program: Javasource_leetcode
 * @description: 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 *     <p>进阶：不要 使用任何内置的库函数，如 sqrt 。
 * @author: Sxuet
 * @create: 2021-09-03 20:49
 */
public class IsPerfectSquare367 {
  /**
   * 暴力解法 避免可能会出现的越界问题
   *
   * <p>执行用时： 1 ms , 在所有 Java 提交中击败了 12.09% 的用户 内存消耗： 35 MB , 在所有 Java 提交中击败了 88.12% 的用户
   *
   * @param num
   * @return
   */
  public static boolean isPerfectSquare1(int num) {
    for (int i = 1; i <= num / i; i++) {
      if (i * i == num) {
        return true;
      }
    }
    return false;
  }

  /**
   * 1 = 1<br>
   * 4 = 1 + 3<br>
   * 9 = 1 + 3 + 5 <br>
   * 16 = 1 + 3 + 5 + 7 <br>
   * ... 根据数学归纳法，我们可以得出： 一个任意的完全平方数，一定是由1->n之间的所有奇数组成。 <br>
   * 那么我们把一个一个的奇数减去，最终结果是0，那么这个数就是完全平方数。 （加法同理）
   *
   * <p>执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 35.1 MB , 在所有 Java 提交中击败了 59.47% 的用户
   *
   * @param num
   * @return
   */
  public static boolean isPerfectSquare2(int num) {
    for (int i = 1; num > 0; i += 2) {
      num -= i;
    }
    return num == 0;
  }

  /**
   * (a + b) / 2 >= sqrt(a * b) // 只有当 a = b， 左右才相等
   *
   * <p>执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 35.2 MB , 在所有 Java 提交中击败了 45.12% 的用户
   *
   * @param num
   * @return
   */
  public static boolean isPerfectSquare3(int num) {
    long i = num;
    while (i * i > num) {
      i = (i + num / i) >> 1;
    }
    return i * i == num;
  }

  /**
   * 二分查找<br>
   * 时间复杂度：O（logN） <br>
   * 空间复杂度：O（1）<br>
   * 从 [1, num] 的区间范围，每次选取中间的值，来判断。 通过二分法，不断压缩选取范围。 <br>
   * 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 35.1 MB , 在所有 Java 提交中击败了 72.87% 的用户
   *
   * @param num
   * @return
   */
  public static boolean isPerfectSquare4(int num) {
    long l = 2, r = num / 2, m, guessSquared;
    while (l <= r) {
      m = l + (r - l) / 2;
      guessSquared = m * m;
      if (guessSquared == num) {
        return true;
      }
      if (guessSquared > num) {
        r = --m;
      } else {
        l = ++m;
      }
    }
    return false;
  }

  /**
   * 牛顿迭代法 遇到求根直接牛顿迭代法！<br>
   * 时间复杂度： O(logN)。 空间复杂度：O(1)。 <br>
   * 对推导过程理解不够的情况下，强行记住公式也是不错的选择， 面试中用此方法，会是加分项。
   *
   * <p>num=x^2; 即：f(x) = x^2-num, 是否存在x令f(x)=0
   *
   * <p>牛顿迭代法的思想是从一个初始近似值开始，然后作一系列改进的逼近根的过程。<br>
   * 我们取num/2作为初始近似值。 <br>
   * 当x*x>num，用牛顿迭代法取计算下一个近似值：x = 1/2(x+num/x) <br>
   * 返回x*x==num。
   *
   * @param num
   * @return
   */
  public static boolean isPerfectSquare5(int num) {
    if (num < 2) {
      return true;
    }
    long x = num / 2;
    while (x * x > num) {
      // 牛顿迭代推导公式，求上述切线与 x 轴的交点
      // 对它不了解，用二分也是很不错的方法，两者性能没多大区别
      x = (x + num / x) / 2;
    }
    return (x * x == num);
  }
}
