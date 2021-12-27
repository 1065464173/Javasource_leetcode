package simple;

/**
 * @program: Javasource_leetcode
 * @description: 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 * @author: Sxuet
 * @create: 2021-09-17 09:16
 */
public class ThirdMax414 {
  /**
   * 设置三个变量 p1,p2,p3 用来记录最大值、第二大值、第三大值。<br>
   * 由于int的范围为( 2^-31,2^31-1],所以三个指针的初值最好比2^-31 还小
   *
   * <p>执行用时： 1 ms , 在所有 Java 提交中击败了 91.79% 的用户 内存消耗： 38.3 MB , 在所有 Java 提交中击败了 36.70% 的用户
   *
   * @param nums
   * @return
   */
  public int thirdMax(int[] nums) {
    // 第一大，第二大，第三大
    long p1 = Long.MIN_VALUE, p2 = Integer.MIN_VALUE, p3 = Integer.MIN_VALUE;
    for (int num : nums) {
      if (num == p1 || num == p2 || num == p3) {
          continue;
      }
      if (num > p1) {
        p3 = p2;
        p2 = p1;
        p1 = num;
      } else if (num > p2) {
        p3 = p2;
        p2 = num;
      } else if (num > p3) {
        p3 = num;
      }
    }
    if (p3 == Long.MIN_VALUE) {
      return (int) p2;
    }
    if (p2 == Long.MIN_VALUE) {
      return (int) p1;
    }
    return (int) p3;
  }
}
