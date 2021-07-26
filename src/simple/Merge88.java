package simple;

import java.util.Arrays;

/**
 * @program: Javasource_leetcode
 * @description: 给你两个有序整数数组nums1 和 nums2，请你将 nums2 合并到nums1中，使 nums1 成为一个有序数组。
 *     <p>初始化nums1 和 nums2 的元素数量分别为m 和 n 。你可以假设nums1 的空间大小等于m + n，这样它就有足够的空间保存来自 nums2 的元素。
 * @author: Sxuet
 * @create: 2021-07-05 11:30
 */
public class Merge88 {
  /**
   * 从num1后面开始覆盖，把最大的放在后面依次向前
   *
   * @param nums1
   * @param m
   * @param nums2
   * @param n
   */
  public void merge3(int[] nums1, int m, int[] nums2, int n) {
    while (n > 0) {
      nums1[m + n - 1] = (m < 1 || nums1[m - 1] < nums2[n - 1]) ? nums2[--n] : nums1[--m];
    }
  }

  /**
   * 合并后排序 时间复杂度O((m+n)log(m+n))。 空间复杂度： O (log(m+n))
   *
   * @param nums1
   * @param m
   * @param nums2
   * @param n
   */
  public void merge1(int[] nums1, int m, int[] nums2, int n) {
    // 合并
    for (int i = 0; i < n; i++) {
      nums1[m + i] = nums2[i];
    }
    // 排序
    Arrays.sort(nums1);
  }

  /**
   * 创建新的数组
   *
   * <p>时间复杂度O(m+n)
   *
   * <p>空间复杂度O(m+n)
   *
   * @param nums1
   * @param m
   * @param nums2
   * @param n
   */
  public void merge2(int[] nums1, int m, int[] nums2, int n) {
    int[] sorted = new int[m + n];
    int n1 = 0;
    int n2 = 0;
    int cur = 0;
    while (n1 < m || n2 < n) {
      if (n1 == m) {
        sorted[cur++] = nums2[n2++];
      } else if (n2 == n) {
        sorted[cur++] = nums1[n1++];
      } else if (nums1[n1] < nums2[n2]) {
        sorted[cur++] = nums1[n1++];
      } else {
        sorted[cur++] = nums2[n2++];
      }
    }
    for (int i = 0; i < m + n; i++) {
      nums1[i] = sorted[i];
    }
  }
}
