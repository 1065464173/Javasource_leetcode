package simple;

/**
 * @program: Javasource_leetcode
 * @description: 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 你可以假设数组中无重复元素
 * @author: Sxuet
 * @create: 2021-06-16 10:08
 */
public class SearchInsert35 {
  public static void main(String[] args) {
    int[] nums = {1, 3, 5, 6};
    int target = 4;
    System.out.println(searchInsert01(nums, target));
    System.out.println(searchInsert02(nums, target));
  }

  /**
   * 自创 时间复杂度O(n) 空间复杂度O(1)
   *
   * @param nums
   * @param target
   * @return
   */
  public static int searchInsert01(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == target) {
        return i;
      } else if (target < nums[i]) {
        return i;
      }
    }
    return nums.length;
  }

  /**
   * 二分算法 O(log2n)
   *
   * @param nums
   * @param target
   * @return
   */
  public static int searchInsert02(int[] nums, int target) {
    int left = 0;
    int right = nums.length;
    while (left <= right) {
      int mid = ((right - left) >> 1) + left;
      if (target <= nums[mid]) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }
}
