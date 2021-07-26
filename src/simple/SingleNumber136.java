package simple;

/**
 * @program: Javasource_leetcode
 * @description: 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *     <p>说明：
 *     <p>你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * @author: Sxuet
 * @create: 2021-07-15 22:48
 */
public class SingleNumber136 {
  /**
   * 自创暴力解法
   *
   * <p>时间复杂度O(n^2)
   *
   * <p>空间复杂度O(1)
   *
   * @param nums
   * @return
   */
  public int singleNumber1(int[] nums) {
    int length = nums.length;
    for (int i = 0; i < length; i++) {
      boolean flag = true;
      for (int j = 0; j < length; j++) {
        if (nums[i] == nums[j] && i != j) {
          flag = false;
          break;
        }
      }
      if (flag) {
        return nums[i];
      }
    }
    return -1;
  }

  /**
   * 位运算，如果一个数异或自己，则为0
   *
   * <p>时间复杂度O(n) n数组长度
   *
   * @param nums
   * @return
   */
  public int singleNumber2(int[] nums) {
    int single = 0;
    for (int i = 0; i < nums.length; i++) {
      single = single ^ nums[i];
    }
    return single;
  }
}
