package simple;

/**
 * @author Sxuet
 * @program daydayup
 * @description 统计一个数字在排序数组中出现的次数。
 * @since 2021-11-13 19:56
 */
public class Search53 {
  public int search1(int[] nums, int target) {
    int ans = 0;
    for (int num : nums) {
      if (num == target) {
        ans++;
      }
    }
    return ans;
  }

  public int search(int[] nums, int target) {
    int leftIdx = binarySearch(nums, target, true);
    int rightIdx = binarySearch(nums, target, false) - 1;
    if (leftIdx <= rightIdx
        && rightIdx < nums.length
        && nums[leftIdx] == target
        && nums[rightIdx] == target) {
      return rightIdx - leftIdx + 1;
    }
    return 0;
  }

  public int binarySearch(int[] nums, int target, boolean lower) {
    int left = 0, right = nums.length - 1, ans = nums.length;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (nums[mid] > target || (lower && nums[mid] >= target)) {
        right = mid - 1;
        ans = mid;
      } else {
        left = mid + 1;
      }
    }
    return ans;
  }
}
