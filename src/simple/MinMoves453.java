package simple;

import java.util.Arrays;

/**
 * @program: Javasource_leetcode
 * @description: 给定一个长度为 n 的 非空 整数数组，每次操作将会使 n - 1 个元素增加 1。找出让数组所有元素相等的最小操作次数。
 * @author: Sxuet
 * @create: 2021-09-28 20:31
 */
public class MinMoves453 {
  /**
   * 暴力解法 时间复杂度：O(（n^2)*k）其中 n 为数组长度，k 为最大值和最小值的差。。 空间复杂度：O（1）。
   *
   * <p>首先，我们知道，为了在最小移动内使所有元素相等，我们需要在数组的最大元素之外的所有元素中执行增加。因此，在暴力法中，我们扫描整个数组以查找最大值和最小元素。此后，我们将1添加到除最大元素之外的所有元素，并增加移动数的计数。同样，我们重复相同的过程，直到最大元素和最小元素彼此相等。
   *
   * @param nums
   * @return
   */
  public int minMoves1(int[] nums) {
    int min = 0, max = nums.length - 1, count = 0;
    while (true) {
      for (int i = 0; i < nums.length; i++) {
        if (nums[max] < nums[i]) {
          max = i;
        }
        if (nums[min] > nums[i]) {
          min = i;
        }
      }
      if (nums[max] == nums[min]) {
        break;
      }
      for (int i = 0; i < nums.length; i++) {
        if (i != max) {
          nums[i]++;
        }
      }
      count++;
    }
    return count;
  }

  /**
   * 对方法一的改造 时间复杂度：O（n2）|空间复杂度：O（1）。
   *
   * <p>为了让最小元素等于最大元素，至少需要加k次。在那之后，最大元素可能发生变化。因此，我们一次性增加增量k=max-min，并将移动次数增加k。然后，对整个数组进行扫描，找到新的最大值和最小值，重复这一过程直到最大元素和最小元素相等。
   *
   * @param nums
   * @return
   */
  public int minMoves2(int[] nums) {
    int min = 0, max = nums.length - 1, count = 0;
    while (true) {
      for (int i = 0; i < nums.length; i++) {
        if (nums[max] < nums[i]) {
          max = i;
        }
        if (nums[min] > nums[i]) {
          min = i;
        }
      }
      int diff = nums[max] - nums[min];
      if (diff == 0) {
        break;
      }
      count += diff;
      for (int i = 0; i < nums.length; i++) {
        if (i != max) {
          nums[i] = nums[i] + diff;
        }
      }
    }
    return count;
  }

  /**
   * 利用排序 时间复杂度：O（nlog（n））。空间复杂度：O（1）
   *
   * @param nums
   * @return
   */
  public int minMoves3(int[] nums) {
    Arrays.sort(nums);
    int count = 0;
    for (int i = nums.length - 1; i > 0; i--) {
      count += nums[i] - nums[0];
    }
    return count;
  }

  /**
   * 动态规划 时间复杂度：O（nlog（n））。排序需要O（nlog（n））的时间。空间复杂度：O（1）。只使用了一个变量。
   *
   * @param nums
   * @return
   */
  public int minMoves(int[] nums) {
    Arrays.sort(nums);
    int moves = 0;
    for (int i = 1; i < nums.length; i++) {
      int diff = (moves + nums[i]) - nums[i - 1];
      nums[i] += moves;
      moves += diff;
    }
    return moves;
  }

  /**
   * 数学法 该方法基于以下思路：将除了一个元素之外的全部元素+1，等价于将该元素-1，因为我们只对元素的相对大小感兴趣。因此，该问题简化为需要进行的减法次数。 <br>
   * 时间复杂度：O（n）。空间复杂度：O（1）。
   *
   * @param nums
   * @return
   */
  public int minMoves4(int[] nums) {
    int moves = 0, min = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length; i++) {
      moves += nums[i];
      min = Math.min(min, nums[i]);
    }
    return moves - min * nums.length;
  }

  /**
   * 改进的数学法 避免整数越界
   *
   * @param nums
   * @return
   */
  public int minMoves5(int[] nums) {
    int moves = 0, min = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length; i++) {
      min = Math.min(min, nums[i]);
    }
    for (int i = 0; i < nums.length; i++) {
      moves += nums[i] - min;
    }
    return moves;
  }
}
