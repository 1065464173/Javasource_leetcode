package simple;

import java.util.Arrays;

/**
 * @author Sxuet
 * @program daydayup
 * @description 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * @since 2021-12-02 09:30
 */
public class MajorityElement39 {
  /**
   * 由于数字出现的次数超过数组长度的一半，所以排序后该数字必出现在中间位 <br>
   * 执行用时： 2 ms , 在所有 Java 提交中击败了 55.13% 的用户 内存消耗： 44.3 MB , 在所有 Java 提交中击败了 27.81% 的用户
   *
   * @param nums
   * @return
   */
  public int majorityElement1(int[] nums) {
    Arrays.sort(nums);

    return nums[nums.length / 2];
  }

  /**
   * 执行用时： 3 ms , 在所有 Java 提交中击败了 31.03% 的用户 内存消耗： 44.4 MB , 在所有 Java 提交中击败了 17.81% 的用户
   *
   * @param nums
   * @return
   */
  public int majorityElement2(int[] nums) {
    int count = 0;
    Integer candidate = null;

    for (int num : nums) {
      if (count == 0) {
        candidate = num;
      }
      count += (num == candidate) ? 1 : -1;
    }

    return candidate;
  }
}
