package simple;

/**
 * @program: Javasource_leetcode
 * @description: 给定一个二进制数组，计算其中最大连续1的个数。
 * @author: Sxuet
 * @create: 2021-10-18 09:45
 */
public class FindMaxConsecutiveOnes485 {
  /**
   * 遍历数组记录最大连续1的值<br>
   * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 39.6 MB , 在所有 Java 提交中击败了 83.12% 的用户
   *
   * @param nums
   * @return
   */
  public int findMaxConsecutiveOnes1(int[] nums) {
    int ans = 0;
    int count = 0;
    for (int num : nums) {
      if (num == 1) {
        count++;
      } else {
        ans = Math.max(ans, count);
        count = 0;
      }
    }
    ans = Math.max(ans, count);

    return ans;
  }
}
