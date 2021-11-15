package simple;

import java.util.HashSet;

/**
 * @author Sxuet
 * @program daydayup
 * @description 找出数组中重复的数字。
 *     在一个长度为n的数组nums里的所有数字都在0~n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * @since 2021-11-13 16:35
 */
public class FindRepeatNumber03 {
  public int findRepeatNumber1(int[] nums) {
    HashSet<Integer> set = new HashSet<>();
    for (int num : nums) {
      if (!set.add(num)) {
        return num;
      }
    }
    return -1;
  }
}
