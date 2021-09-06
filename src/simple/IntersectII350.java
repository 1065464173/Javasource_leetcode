package simple;

import java.util.Arrays;

/**
 * @program: Javasource_leetcode
 * @description: 给定两个数组，编写一个函数来计算它们的交集。
 * @author: Sxuet
 * @create: 2021-09-02 22:49
 */
public class IntersectII350 {
  /**
   * 排序+双指针 <br>
   * 时间复杂度：O(mlogm+nlogn) 空间复杂度：O(min(m，n))
   *
   * @param nums1
   * @param nums2
   * @return
   */
  public int[] intersect(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int length1 = nums1.length, length2 = nums2.length;
    int[] res = new int[Math.min(length1, length2)];
    int index = 0, index1 = 0, index2 = 0;
    while (index1 < length1 && index2 < length2) {
      if (nums1[index1] == nums2[index2]) {
        res[index++] = nums1[index1++];
        index2++;
      } else if (nums1[index1] < nums2[index2]) {
        index1++;
      } else {
        index2++;
      }
    }
    return Arrays.copyOfRange(res, 0, index);
  }
}
