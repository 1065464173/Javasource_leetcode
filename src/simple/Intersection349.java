package simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @program: Javasource_leetcode
 * @description: 给定两个数组，编写一个函数来计算它们的交集
 * @author: Sxuet
 * @create: 2021-09-02 22:25
 */
public class Intersection349 {
  /**
   * 自创遍历两个集合 <br>
   * 时间 O(MN) 空间O(M+N))<br>
   * 执行用时： 2 ms , 在所有 Java 提交中击败了 93.64% 的用户 内存消耗： 38.7 MB , 在所有 Java 提交中击败了 34.68% 的用户
   *
   * @param nums1
   * @param nums2
   * @return
   */
  public int[] intersection1(int[] nums1, int[] nums2) {
    HashSet<Integer> set = new HashSet<>();
    for (int i1 : nums1) {
      set.add(i1);
    }
    ArrayList<Integer> list = new ArrayList<>();
    for (int i2 : nums2) {
      if (set.contains(i2)) {
        set.remove(i2);
        list.add(i2);
      }
    }
    int[] res = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      res[i] = list.get(i);
    }
    return res;
  }

  /**
   * 排序+双指针 <br>
   * 如果两个数组是有序的，则可以使用双指针的方法得到两个数组的交集。 <br>
   * 时间复杂度：O(mlogm+nlogn) 空间复杂度：O(logm+logn) <br>
   * 执行用时： 1 ms , 在所有 Java 提交中击败了 99.95% 的用户 内存消耗： 38.6 MB , 在所有 Java 提交中击败了 57.26% 的用户
   *
   * @param nums1
   * @param nums2
   * @return
   */
  public int[] intersection2(int[] nums1, int[] nums2) {
    // 排序
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int length1 = nums1.length, length2 = nums2.length;
    int[] intersection = new int[length1 + length2];
    int index = 0, index1 = 0, index2 = 0;

    while (index1 < length1 && index2 < length2) {
      int num1 = nums1[index1], num2 = nums2[index2];
      if (num1 == num2) {
        // 保证加入元素的唯一性
        if (index == 0 || num1 != intersection[index - 1]) {
          intersection[index++] = num1;
        }
        index1++;
        index2++;
      } else if (num1 < num2) {
        index1++;
      } else {
        index2++;
      }
    }
    return Arrays.copyOfRange(intersection, 0, index);
  }
}
