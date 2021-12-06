package difficult;

import liquibase.pro.packaged.I;
import liquibase.pro.packaged.M;
import simple.MinArray11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Sxuet
 * @program daydayup
 * @description 给定一个数组nums和滑动窗口的大小k，请找出所有滑动窗口里的最大值。
 * @since 2021-12-06 09:27
 */
public class MaxSlidingWindowI59 {

  /**
   * 使用滑动窗口 执行用时： 3 ms , 在所有 Java 提交中击败了 94.25% 的用户 内存消耗： 46.3 MB , 在所有 Java 提交中击败了 82.63% 的用户
   *
   * @param nums
   * @param k
   * @return
   */
  public int[] maxSlidingWindow1(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return new int[0];
    }
    int len = nums.length;
    int[] ans = new int[len - k + 1];
    ans[0] = maxValue(nums, 0, k);
    for (int i = 1; i <= len - k; i++) {
      if (nums[i - 1] == ans[i - 1]) {
        ans[i] = maxValue(nums, i, i + k);
      } else {
        ans[i] = Math.max(ans[i - 1], nums[i - 1 + k]);
      }
    }
    return ans;
  }

  private int maxValue(int[] nums, int left, int right) {
    int max = Integer.MIN_VALUE;
    for (int i = left; i < right; i++) {
      max = Math.max(nums[i], max);
    }
    return max;
  }

  /**
   * 有限队列 <br>
   * 执行用时： 12 ms , 在所有 Java 提交中击败了 73.69% 的用户 内存消耗： 47.2 MB , 在所有 Java 提交中击败了 41.27% 的用户
   *
   * @param nums
   * @param k
   * @return
   */
  public int[] maxSlidingWindow2(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return new int[0];
    }
    int n = nums.length;
    // 大顶堆 - 堆顶存放值最大的元素
    PriorityQueue<int[]> pq =
        new PriorityQueue<>(
            (pair1, pair2) -> pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1]);
    for (int i = 0; i < k; ++i) {
      pq.offer(new int[] {nums[i], i});
    }
    int[] ans = new int[n - k + 1];
    // 取出最大值
    ans[0] = pq.peek()[0];
    for (int i = k; i < n; ++i) {
      pq.offer(new int[] {nums[i], i});
      // 如果最大值是滑动窗口意外的值，则将其弹栈
      while (pq.peek()[1] <= i - k) {
        pq.poll();
      }
      // 堆顶永远是最大值
      ans[i - k + 1] = pq.peek()[0];
    }
    return ans;
  }

  /**
   * 执行用时： 3 ms , 在所有 Java 提交中击败了 94.25% 的用户 内存消耗： 46.4 MB , 在所有 Java 提交中击败了 77.19% 的用户
   *
   * @param nums
   * @param k
   * @return
   */
  public int[] maxSlidingWindow3(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return new int[0];
    }
    int n = nums.length;
    int[] prefixMax = new int[n];
    int[] suffixMax = new int[n];
    for (int i = 0; i < n; ++i) {
      if (i % k == 0) {
        prefixMax[i] = nums[i];
      }
      else {
        prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
      }
    }
    for (int i = n - 1; i >= 0; --i) {
      if (i == n - 1 || (i + 1) % k == 0) {
        suffixMax[i] = nums[i];
      } else {
        suffixMax[i] = Math.max(suffixMax[i + 1], nums[i]);
      }
    }

    int[] ans = new int[n - k + 1];
    for (int i = 0; i <= n - k; ++i) {
      ans[i] = Math.max(suffixMax[i], prefixMax[i + k - 1]);
    }
    return ans;
  }
}
