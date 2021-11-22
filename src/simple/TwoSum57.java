package simple;

/**
 * @author Sxuet
 * @program daydayup
 * @description 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 * @since 2021-11-22 10:02
 */
public class TwoSum57 {
  /**
   * 双指针实现
   *
   * @param nums
   * @param target
   * @return
   */
  public int[] twoSum1(int[] nums, int target) {
    int p1 = 0, p2 = nums.length - 1;
    while (p1 < p2) {
      while (nums[p2] > target) {
        p2--;
      }
      int n1 = nums[p1];
      int n2 = nums[p2];
      if (n1 + n2 < target) {
        p1++;
      } else if (n1 + n2 > target) {
        p2--;
      } else {
        return new int[] {n1, n2};
      }
    }
    return new int[0];
  }

  /**
   * 精选答案-双指针-对方法一的时间简化<br>
   * 执行用时： 1 ms , 在所有 Java 提交中击败了 99.81% 的用户 内存消耗： 55.2 MB , 在所有 Java 提交中击败了 79.40% 的用户
   *
   * @param nums
   * @param target
   * @return
   */
  public int[] twoSum2(int[] nums, int target) {
    int i = 0, j = nums.length - 1;
    while (i < j) {
      int s = nums[i] + nums[j];
      if (s < target) i++;
      else if (s > target) j--;
      else return new int[] {nums[i], nums[j]};
    }
    return new int[0];
  }
}
