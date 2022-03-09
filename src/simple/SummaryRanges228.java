package simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Javasource_leetcode
 * @description: 给定一个无重复元素的有序整数数组 nums 。
 *     <p>返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 *     <p>列表中的每个区间范围 [a,b] 应该按如下格式输出：
 *     <p>"a->b" ，如果 a != b "a" ，如果 a == b
 * @author: Sxuet
 * @create: 2021-08-05 21:14
 */
public class SummaryRanges228 {
  /**
   * 自己写的迭代 时间复杂符O(n) 遍历一次。 空间O(n) 最坏每个值凑要存进Arraylist里<br>
   * 执行用时： 7 ms , 在所有 Java 提交中击败了 53.05% 的用户 内存消耗： 37.1 MB , 在所有 Java 提交中击败了 5.09% 的用户
   *
   * @param nums
   * @return
   */
  public List<String> summaryRanges1(int[] nums) {
    List<String> list = new ArrayList<>();
    // 如果nums为空直接返回空list
    if (nums == null || nums.length == 0) {
      return list;
    }
    // pre，记录开头数，记录连续数的个数
    int pre = 0, count = 0;
    for (int cur = 1; cur < nums.length; cur++) {
      // 如果连续，连续数+1
      if (nums[cur - 1] + 1 == nums[cur]) {
        count++;
      } else {
        // 不连续了 添加到list集合里
        list.add(count == 0 ? (nums[pre] + "") : (nums[pre] + "->" + nums[pre + count]));
        // 重置pre为当前数，count归0
        pre = cur;
        count = 0;
      }
    }
    // 添加剩下的数
    list.add(count == 0 ? (nums[pre] + "") : (nums[pre] + "->" + nums[pre + count]));
    return list;
  }

  /**
   * 官方的一次遍历 <br>
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 36.2 MB , 在所有 Java 提交中击败了 94.68% 的用户
   *
   * <p>时间复杂度： O(n)，其中 n 为数组的长度。 空间复杂度：O(1)。除了用于输出的空间外，额外使用的空间为常数。
   *
   * @param nums
   * @return
   */
  public List<String> summaryRanges2(int[] nums) {
    List<String> ret = new ArrayList<String>();
    int i = 0;
    int n = nums.length;
    while (i < n) {
      int low = i;
      i++;
      while (i < n && nums[i] == nums[i - 1] + 1) {
        i++;
      }
      int high = i - 1;
      // 这种方式比直接list.add(count == 0 ? (nums[pre] + "") : (nums[pre] + "->" + nums[pre + count]))省空间
      StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
      if (low < high) {
        temp.append("->");
        temp.append(Integer.toString(nums[high]));
      }
      ret.add(temp.toString());
    }
    return ret;
  }
}
