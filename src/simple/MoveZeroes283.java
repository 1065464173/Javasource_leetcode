package simple;

import java.util.ArrayList;

/**
 * @program: Javasource_leetcode
 * @description: 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * @author: Sxuet
 * @create: 2021-08-23 12:48
 */
public class MoveZeroes283 {
  /**
   * 自己写的暴力解法 遍历数组将非0数记录到Arraylist，同时记录0的个数 <br>
   * 完成后将list转换为nums ——int[] 数组 <br>
   * 执行用时： 1 ms , 在所有 Java 提交中击败了 16.19% 的用户 内存消耗： 38.2 MB , 在所有 Java 提交中击败了 96.75% 的用户
   *
   * @param nums
   */
  public void moveZeroes1(int[] nums) {
    ArrayList<Integer> list = new ArrayList<>();
    int zeroNum = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        list.add(nums[i]);
      } else {
        zeroNum++;
      }
    }
    for (int i = 0; i < zeroNum; i++) {
      list.add(0);
    }
    for (int i = 0; i < list.size(); i++) {
      nums[i] = list.get(i);
    }
  }

  /**
   * 自创算法 比官方的双指针还快<br>
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 38.6 MB , 在所有 Java 提交中击败了 65.59% 的用户
   *
   * @param nums
   */
  public void moveZeroes2(int[] nums) {
    int i = 0;
    int j = 0;
    while (i < nums.length) {
      if (nums[i] != 0) {
        nums[j++] = nums[i];
      }
      i++;
    }
    while (j < nums.length) {
      nums[j++] = 0;
    }
  }
}
