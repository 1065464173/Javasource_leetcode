package simple;

/**
 * @author Sxuet
 * @program daydayup
 * @description 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0~n-1之内。在范围0~n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * @since 2021-11-13 20:52
 */
public class MissingNumber53 {
  public int missingNumber1(int[] nums) {
    int ans = 0;
    for (int i = 0; i < nums.length; i++) {
      ans = ans + i - nums[i];
    }
    return ans + nums.length;
  }

  public int missingNumber2(int[] nums) {
    int i = 0, j = nums.length - 1;
    while (i <= j) {
      int m = (i + j) / 2;
      if (nums[m] == m) i = m + 1;
      else j = m - 1;
    }
    return i;
  }
}
