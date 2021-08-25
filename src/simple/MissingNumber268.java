package simple;

import java.util.Arrays;

/**
 * @program: Javasource_leetcode
 * @description: 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 * @author: Sxuet
 * @create: 2021-08-19 11:51
 */
public class MissingNumber268 {
  /**
   * 自创的排序遍历。先排序，后遍历缺少哪个数字。
   *
   * <p>快排时间复杂度O(n log(n)) 空间O(1)
   *
   * @param nums
   * @return
   */
  public int missingNumber1(int[] nums) {
    int n = nums.length;
    Arrays.sort(nums);
    for (int i = 0; i < n; i++) {
      if (nums[i] != i) {
        return i;
      }
    }
    return n;
  }

  /**
   * 自创遍历两次数组 时间O(n) 空间O(n)
   *
   * <p>执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 38.7 MB , 在所有 Java 提交中击败了 66.37% 的用户
   *
   * @param nums
   * @return
   */
  public int missingNumber2(int[] nums) {
    int n = nums.length;
    int[] count = new int[n + 1];
    for (int num : nums) {
      count[num]++;
    }
    for (int i = 0; i < n; i++) {
      if (count[i] == 0) {
        return i;
      }
    }
    return n;
  }

  /**
   * 位运算 时间复杂度O(n) 空间O(1)
   *
   * @param nums
   * @return
   */
  public int missingNumber3(int[] nums) {
    int res = nums.length;
    for (int i = 0; i < nums.length; i++) {
      res ^= nums[i] ^ i;
    }
    return res;
  }

  /**
   * 使用高斯求和公式求 0-n和和。减去数组中所有的数即所缺失的数字 <br>
   * 时间复杂度O(n) 空间O(1)
   *
   * @param nums
   * @return
   */
  public int missingNumber4(int[] nums) {
    int res = nums.length * (nums.length + 1) / 2;
    for (int num : nums) {
      res -= num;
    }
    return res;
  }
}
