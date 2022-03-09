package simple;

/**
 * @program: JavaSE_learning
 * @description: 给你一个数组 nums和一个值 val 你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。 不要使用额外的数组空间，你必须仅使用 O(1)
 *     额外空间并 原地 修改输入数组。 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素
 * @author: Sxuet
 * @create: 2021-06-10 15:40
 */
public class RemoveElement27 {
  public static void main(String[] args) {
    int[] nums = {1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 5};
    //        int len = removeElement1(nums, 2);
    //        int len = removeElement2(nums, 2);
    int len = removeElement3(nums, 2);
    for (int i = 0; i < len; i++) {
      System.out.println(nums[i]);
    }
  }

  /**
   * @description: 优化双指针
   * @param: [nums, val]
   * @return: int
   * @author: Sxuet
   * @date: 2021/6/10 9:22 下午
   */
  public static int removeElement3(int[] nums, int val) {
    int left = 0;
    int right = nums.length;
    while (left < right) {
      if (nums[left] == val) {
        nums[left] = nums[right - 1];
        right--;
      } else {
        left++;
      }
    }
    return left;
  }

  /**
   * @description: 自创暴力解法
   * @param: int[] nums
   * @param: int val
   * @return: int
   * @author: Sxuet
   * @date: 2021/6/10 3:41 下午
   */
  public static int removeElement1(int[] nums, int val) {
    int len = nums.length;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == val) {
        for (int j = i + 1; j < nums.length; j++) {
          nums[j - 1] = nums[j];
        }
        len--;
        i--;
      }
    }
    return len;
  }

  /**
   * @description: 双指针.时间O(n), 空间O(1)
   * @param: [nums, val]
   * @return: int
   * @author: Sxuet
   * @date: 2021/6/10 8:11 下午
   */
  public static int removeElement2(int[] nums, int val) {
    int left = 0;
    for (int right = 0; right < nums.length; right++) {
      if (nums[right] != val) {
        nums[left++] = nums[right];
      }
    }
    return left;
  }
}
