package simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Javasource_leetcode
 * @description: 给定一个排序的整数数组 nums ，其中元素的范围在 闭区间 [lower, upper] 当中，返回不包含在数组中的缺失区间。
 * @author: Sxuet
 * @create: 2021-07-21 21:57
 */
public class FindMissingRanges163 {
  /**
   * 双指针
   *
   * @param nums
   * @param lower
   * @param upper
   * @return
   */
  public List<String> findMissingRanges1(int[] nums, int lower, int upper) {
    // TODO:解题不多。只有一种方法。这题有点呆
    List<String> res = new ArrayList<>();
    long pre = (long) lower - 1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] - pre == 2) {
        res.add(String.valueOf(pre + 1));
      } else if (nums[i] - pre > 2) {
        res.add((pre + 1) + "->" + (nums[i] - 1));
      }
      pre = nums[i];
    }
    if (upper - pre == 1) {
      res.add(String.valueOf(pre + 1));
    } else if (upper - pre > 1) {
      res.add((pre + 1) + "->" + upper);
    }

    return res;
  }
}
