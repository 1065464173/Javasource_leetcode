package simple;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Sxuet
 * @program daydayup
 * @description 输入整数数组arr，找出其中最小的k个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * @since 2021-11-26 10:29
 */
public class GetLeastNumbers40 {
  /**
   * 内置快排函数<br>
   * 执行用时： 6 ms , 在所有 Java 提交中击败了 72.16% 的用户 内存消耗： 39.9 MB , 在所有 Java 提交中击败了 14.98% 的用户
   *
   * @param arr
   * @param k
   * @return
   */
  public int[] getLeastNumbers1(int[] arr, int k) {
    Arrays.sort(arr);
    return Arrays.copyOfRange(arr, 0, k);
  }

  /**
   * 大顶堆<br>
   * 执行用时： 17 ms , 在所有 Java 提交中击败了 24.34% 的用户 内存消耗： 39.6 MB , 在所有 Java 提交中击败了 75.53% 的用户
   *
   * @param arr
   * @param k
   * @return
   */
  public int[] getLeastNumbers2(int[] arr, int k) {
    int[] vec = new int[k];
    if (k == 0) {
      return vec;
    }
    PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
    for (int i = 0; i < k; i++) {
      queue.offer(arr[i]);
    }
    for (int i = k; i < arr.length; i++) {
      if (queue.peek() > arr[i]) {
        queue.poll();
        queue.offer(arr[i]);
      }
    }
    for (int i = 0; i < k; i++) {
      vec[i] = queue.poll();
    }
    return vec;
  }
}
