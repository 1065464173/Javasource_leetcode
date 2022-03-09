package simple;

/**
 * @program: Javasource_leetcode
 * @description: 你总共有n枚硬币，你需要将它们摆成一个阶梯形状，第k行就必须正好有k枚硬币。
 *     <p>给定一个数字n，找出可形成完整阶梯行的总行数。
 *     <p>n是一个非负整数，并且在32位有符号整型的范围内。
 * @author: Sxuet
 * @create: 2021-09-22 21:25
 */
public class ArrangeCoins441 {
  public static void main(String[] args) {
    arrangeCoins2(5);
  }

  /**
   * 到第 k 行时的总硬币数等于 k(k+1)/2 <br>
   * 只要找到最接近 n 的那个 k 就可以了 <br>
   * 时间复杂度：O（logn）。空间复杂度：O（1）。<br>
   * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 35.5 MB , 在所有 Java 提交中击败了 68.28% 的用户
   *
   * @param n
   * @return
   */
  public static int arrangeCoins2(int n) {
    // 1,2,3,4,5
    // 到第 k 行时的总硬币数等于 k(k+1)/2
    // 只要找到最接近 n 的那个 k 就可以了
    // 所以，我们可以使用二分查找
    long left = 1, right = n;
    while (left <= right) {
      long mid = left + (right - left) / 2;
      long total = mid * (mid + 1) / 2;
      if (total == n) {
        return (int) mid;
      }
      if (total > n) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return (int) right;
  }

  /**
   * 暴力解法，从1开始减，每次减后的值大于0的话就记录完整层数+1<br>
   * 执行用时： 8 ms , 在所有 Java 提交中击败了 35.56% 的用户 内存消耗： 35.7 MB , 在所有 Java 提交中击败了 16.39% 的用户
   *
   * @param n
   * @return
   */
  public int arrangeCoins1(int n) {

    int ans = 0;
    for (int i = 1; i < n; i++) {
      if ((n -= i) < 0) {
        return ans;
      }
      ans++;
    }
    return ans;
  }
}
