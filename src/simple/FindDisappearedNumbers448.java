package simple;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @program: Javasource_leetcode
 * @description:
 * @author: Sxuet
 * @create: 2021-09-24 20:56
 */
public class FindDisappearedNumbers448 {
  /**
   * 暴力解法，添加一遍数组到哈希表里，在从1遍历到n看set表里是都存在该数组，不存在就添加到list中<br>
   * 提交中击败了 19.79% 的用户 内存消耗： 47.2 MB , 在所有 Java 提交中击败了 65.97% 的用户
   *
   * @param nums
   * @return
   */
  public List<Integer> findDisappearedNumbers1(int[] nums) {
    List<Integer> ans = new ArrayList<>();
    HashSet<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }
    for (int i = 1; i <= nums.length; i++) {
      if (!set.contains(i)) {
        ans.add(i);
      }
    }
    return ans;
  }

  /**
   * 数组记录代替哈希表，空间O(n),时间O(n) n为数组长度<br>
   * 执行用时： 3 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 47.6 MB , 在所有 Java 提交中击败了 15.87% 的用户
   *
   * @param nums
   * @return
   */
  public List<Integer> findDisappearedNumbers2(int[] nums) {
    List<Integer> ans = new ArrayList<>();
    int length = nums.length;
    int[] count = new int[length + 1];
    for (int i = 1; i <= length; i++) {
      count[nums[i - 1]]++;
    }
    for (int i = 1; i <= length; i++) {
      if (count[i] == 0) {
        ans.add(i);
      }
    }
    return ans;
  }

  /**
   * 原地修改，优化上一个方法，将空间降到O(1)，注意到nums的长度恰好也为n，直接让nums充当哈希表
   *
   * <p>具体来说，遍历nums，每遇到一个数x，就让nums【x-1】增加n。由于nums中所有数均在【1，n】中，增加以后，这些数必然大于n。最后我们遍历nums，若nums【i】未大于n，就说明没有遇到过数i+1。这样我们就找到了缺失的数字。
   *
   * <p>执行用时： 3 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 47.3 MB , 在所有 Java 提交中击败了 54.46% 的用户
   *
   * @param nums
   * @return
   */
  public List<Integer> findDisappearedNumbers3(int[] nums) {
    List<Integer> ans = new ArrayList<>();
    int n = nums.length;
    for (int num : nums) {
      // 注意，当我们遍历到某个位置时，其中的数可能已经被增加过，因此需要对n取模来还原出它本来的值。
      int x = (num - 1) % n;
      nums[x] += n;
    }
    for (int i = 0; i < n; i++) {
      if (nums[i] <= n) {
        ans.add(i + 1);
      }
    }
    return ans;
  }
}
