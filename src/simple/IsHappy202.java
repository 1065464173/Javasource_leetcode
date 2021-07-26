package simple;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: Javasource_leetcode
 * @description: 编写一个算法来判断一个数 n 是不是快乐数。
 *     <p>「快乐数」定义为：
 *     <p>对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。 如果 可以变为
 *     1，那么这个数就是快乐数。 如果 n 是快乐数就返回 true ；不是，则返回 false
 * @author: Sxuet
 * @create: 2021-07-29 21:34
 */
public class IsHappy202 {
  /**
   * 分析： 猜测会有以下三种可能。<br>
   * 最终会得到 1。<br>
   * 最终会进入循环。 <br>
   * 值会越来越大，最后接近无穷大<br>
   * 然而第三种情况永远不会发生，因为最大一位数9的下一位是81，两位数最大99下一位162，三位数999下一位243，所以会停在243内永远做循环
   */

  /**
   * 数学， 根据我们之前的分析，我们知道它必须低于 243。因此，我们知道任何循环都必须包含小于 243 的数字，用这么小的数字，编写一个能找到所有周期的强力程序并不困难。
   *
   * <p>所有会循环的数字最终或落在4, 16, 37, 58, 89, 145, 42, 20，4。我们可以硬编码一个包含这些数字的散列集，如果我们达到其中一个数字，那么我们就知道在循环中
   *
   * <p>时间O(logn) 空间O(1)
   *
   * @param n
   * @return
   */
  private static Set<Integer> cycleMembers =
      new HashSet<>(Arrays.asList(4, 16, 37, 58, 89, 145, 42, 20));

  /**
   * 自创写法 使用hash表记录，每次循环判断一下是否存在，存在则认定进去无限循环，返回false
   *
   * <p>时间复杂度 O(243⋅3+logn+loglogn+logloglogn)... =O(logn)。 空间复杂度：O(logn)
   *
   * @param n
   * @return
   */
  public boolean isHappy1(int n) {
    HashSet<Integer> set = new HashSet<>();
    while (n != 1) {
      int num = 0;
      while (n != 0) {
        num += Math.pow(n % 10, 2);
        n /= 10;
      }
      n = num;
      if (set.contains(n)) {
        return false;
      }
      set.add(n);
    }
    return true;
  }

  /**
   * 快慢指针——龟兔赛跑
   *
   * <p>时间O(logn) 空间O(1)
   *
   * @param n
   * @return
   */
  public boolean isHappy2(int n) {
    int slow = n;
    int fast = getNext(n);
    while (fast != 1 && fast != slow) {
      fast = getNext(getNext(fast));
      slow = getNext(slow);
    }
    return fast == 1;
  }

  public int getNext(int n) {
    int totalSum = 0;
    while (n > 0) {
      int d = n % 10;
      n = n / 10;
      totalSum += d * d;
    }
    return totalSum;
  }

  public boolean isHappy(int n) {
    while (n != 1 && !cycleMembers.contains(n)) {
      n = getNext(n);
    }
    return n == 1;
  }
}
