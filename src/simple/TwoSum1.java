package simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Sxuet @Date: 2021-06-02 14:50:07 @LastEditTime: 2021-06-03 14:56:06 @LastEditors:
 * Sxuet @FilePath: /JavaSE_learning/Javasource_leetcode/TwoSum1.java @Description: 给定一个整数数组
 * nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标.
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 你可以按任意顺序返回答案。
 */
public class TwoSum1 {
  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4, 5};
    int target = 4;
    int[] result = twoSum1(nums, target);
    for (int i : result) {
      System.out.println(i);
    }
  }

  /**
   * 方法一：暴力计算 空间复杂度O(1),时间复杂度O(n^2)
   *
   * @param {*}
   * @return {*}
   */
  public static int[] twoSum1(int[] nums, int target) {

    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if ((nums[i] + nums[j]) == target) {
          return new int[] {i, j};
        }
      }
    }
    return new int[0];
  }

  /**
   * 方法二：创建一个哈希表，对于每一个 x，我们首先查询哈希表中是否存在 target - x， 然后将 x 插入到哈希表中，即可保证不会让 x 和自己匹配。
   * 空间负责度O(n),主要为哈希表的开销。,时间复杂度O(n) @Author: Sxuet @Date: 2021-06-02 15:12:45
   *
   * @param {int[]} nums
   * @param {int} target
   * @return {*}
   */
  public static int[] twoSum2(int[] nums, int target) {

    Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>(nums.length);
    for (int i = 0; i < nums.length; ++i) {
      if (hashtable.containsKey(target - nums[i])) {
        return new int[] {hashtable.get(target - nums[i]), i};
      }
      hashtable.put(nums[i], i);
    }
    return new int[0];
  }
}
