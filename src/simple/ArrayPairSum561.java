package simple;

import java.util.Arrays;

/**
 * @author Sxuet
 * @program Javasource_leetcode
 * @description 给定长度为2n的整数数组nums，你的任务是将这些数分成n对，例如（a1，b1），（a2，b2）， （anrbn），使得从1到n的 min（airbi）总和最大。
 *     返回该最大总和。
 * @since 2021-11-08 13:46
 */
public class ArrayPairSum561 {
  /**
   * 执行用时： 12 ms , 在所有 Java 提交中击败了 98.29% 的用户 内存消耗： 40.8 MB , 在所有 Java 提交中击败了 23.73% 的用户
   *
   * @param nums
   * @return
   */
  public int arrayPairSum(int[] nums) {
    // 根据规律可得，尽量使两个差值最小的数相组合得到的minSum最大
    // 将nums排序，求得的minSum就等于nums的奇数位相加
    Arrays.sort(nums);
    int minSum = 0;
    for (int i = 0; i < nums.length; i += 2) {
      minSum += nums[i];
    }
    return minSum;
  }
}
