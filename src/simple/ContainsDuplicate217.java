package simple;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.IntStream;

/**
 * @program: Javasource_leetcode
 * @description: 给定一个整数数组，判断是否存在重复元素。
 *     <p>如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * @author: Sxuet
 * @create: 2021-08-02 20:40
 */
public class ContainsDuplicate217 {
  /**
   * 自己写的哈希表 时间O(n) 空间O(n)
   *
   * @param nums
   * @return
   */
  public boolean containsDuplicate1(int[] nums) {
    HashSet<Integer> set = new HashSet<>();
    for (int num : nums) {
      if (set.contains(num)) {
        return true;
      }
      set.add(num);
    }
    return false;
  }

  /**
   * 在上面的基础上加了双指针 不过好像对性能没有什么改变
   *
   * <p>执行用时： 7 ms , 在所有 Java 提交中击败了 38.22% 的用户 内存消耗： 42.2 MB , 在所有 Java 提交中击败了 64.36% 的用户
   *
   * @param nums
   * @return
   */
  public boolean containsDuplicate2(int[] nums) {
    HashSet<Integer> set = new HashSet<>();
    int p1 = 0, p2 = nums.length - 1;
    while (p1 < p2) {
      if (nums[p1] == nums[p2] || set.contains(nums[p1]) || set.contains(nums[p2])) {
        return true;
      }
      set.add(nums[p1]);
      set.add(nums[p2]);
      p1++;
      p2--;
    }
    return false;
  }

  /**
   * 排序 时间复杂度：O(NlogN)，其中 N 为数组的长度。需要对数组进行排序。 空间复杂度：O(logN)，其中 N 为数组的长度。注意我们在这里应当考虑递归调用栈的深度。
   *
   * @param nums
   * @return
   */
  public boolean containsDuplicate3(int[] nums) {
    // O(n log(n))
    Arrays.sort(nums);
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[i - 1]) {
        return true;
      }
    }
    return false;
  }

  /**
   * Java 可以用 stream 实现一行将 int[] 转成 Set<Integer> 。为了更简短一些，可以直接利用 stream 的 distinct 和 count 算子。
   * 时间空间O(n)
   *
   * @param nums
   * @return
   */
  public boolean containsDuplicate4(int[] nums) {
    return IntStream.of(nums).distinct().count() != nums.length;
  }
}
