package simple;
/**
 * @Author: Sxuet @Date: 2021-06-07 10:41:55 @LastEditTime: 2021-06-07 11:35:05 @LastEditors:
 * Sxuet @FilePath: /JavaSE_learning/Javasource_leetcode/RemoveDuplicates26.java @Description:
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1)
 * 额外空间的条件下完成。 0 <= nums.length <= 3 * 104 -104 <= nums[i] <= 104 nums 已按升序排列
 */

/** @author sxuet */
@SuppressWarnings("AlibabaTestClassShouldEndWithTestNaming")
public class RemoveDuplicates26 {

  public void test() {
    int[] nums = {1, 1, 2};
    int len = removeDuplicates(nums);
    for (int i = 0; i < len; i++) {
      System.out.print(nums[i] + " ");
    }
  }

  public int removeDuplicates(int[] nums) {
    int len = nums.length;
    if (len == 0) {
      return 0;
    }
    int slow = 1;
    int fast = 1;
    while (fast < len) {
      if (nums[fast] != nums[fast - 1]) {
        nums[slow++] = nums[fast];
      } else {
        fast++;
      }
    }
    return slow;
  }

  /*
   @description: 自己写的暴力解法
  * @Author: Sxuet
  * @Date: 2021-06-07 11:25:59
  * @param {int[]} nums
  * @return {*}
  */

}
