package simple;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Sxuet
 * @program Javasource_leetcode
 * @description 给你两个没有重复元素的数组nums1和nums2，其中nums1是nums2的子集。 请你找出nums1中每个元素在nums2中的下一个比其大的值。
 *     nums1中数字x的下一个更大元素是指x在nums2中对应位置的右边的第一个比x大的元素。如果不存在，对应位置输出-1。
 * @since 2021-10-24 13:46
 */
public class NextGreaterElement496 {
  /**
   * 暴力解法
   *
   * @param nums1 - num2的子数组
   * @param nums2 - 一个无序数组
   * @return 数组每个元素比较完的结果
   */
  public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
    for (int i = 0; i < nums1.length; i++) {
      boolean flag = false;
      for (int j = 0; j < nums2.length; j++) {
        if (nums1[i] == nums2[j]) {
          flag = true;
        }
        if (flag && nums2[j] > nums1[i]) {
          nums1[i] = nums2[j];
          break;
        } else if (j == nums2.length - 1) {
          nums1[i] = -1;
        }
      }
    }
    return nums1;
  }

  /**
   * 单调栈 <br>
   * 执行用时： 3 ms , 在所有 Java 提交中击败了 91.68% 的用户 内存消耗： 38.8 MB , 在所有 Java 提交中击败了 11.52% 的用户
   *
   * @param nums1 - num2的子数组
   * @param nums2 - 一个无序数组
   * @return 数组每个元素比较完的结果
   */
  public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
    int len1 = nums1.length;
    int len2 = nums2.length;

    Deque<Integer> stack = new ArrayDeque<>();
    Map<Integer, Integer> map = new HashMap<>();
    // 先处理 nums2，把对应关系存入哈希表
    for (int j : nums2) {
      while (!stack.isEmpty() && stack.peekLast() < j) {
        // 如果栈非空且栈不能继续单调，则全部弹栈
        map.put(stack.removeLast(), j);
      }

      stack.addLast(j);
    }

    // 遍历 nums1 得到结果集
    int[] res = new int[len1];
    for (int i = 0; i < len1; i++) {
      res[i] = map.getOrDefault(nums1[i], -1);
    }
    return res;
  }
}
