package simple;

/**
 * @author Sxuet
 * @program daydayup
 * @description 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 * @since 2021-11-22 09:42
 */
public class Exchange21 {

  /**
   * 双指针 - 新建数组存放遍历结果 - 更简单易懂 <br>
   * 执行用时： 2 ms , 在所有 Java 提交中击败了 79.35% 的用户 内存消耗： 48 MB , 在所有 Java 提交中击败了 5.17% 的用户
   *
   * @param nums
   * @return
   */
  public int[] exchange1(int[] nums) {
    int length = nums.length;
    int[] ans = new int[length];
    int p1 = 0, p2 = length - 1;
    for (int num : nums) {
      if (num % 2 == 0) {
        ans[p2--] = num;
      } else {
        ans[p1++] = num;
      }
    }
    return ans;
  }

  /**
   * 对1的改进，在原地更换奇偶 <br>
   * 执行用时： 2 ms , 在所有 Java 提交中击败了 79.35% 的用户 内存消耗： 46.3 MB , 在所有 Java 提交中击败了 60.96% 的用户
   *
   * @param nums
   * @return
   */
  public int[] exchange2(int[] nums) {
    int p1 = 0, p2 = nums.length - 1, temp;
    while (p1 < p2) {
      while (nums[p1] % 2 != 0 && p1 < p2) {
        p1++;
      }
      while (nums[p2] % 2 == 0 && p1 < p2) {
        p2--;
      }
      temp = nums[p1];
      nums[p1] = nums[p2];
      nums[p2] = temp;
    }
    return nums;
  }

  /**
   * 官方的更优雅的方法二实现 事实证明位运算也更快 <br>
   * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 46.3 MB , 在所有 Java 提交中击败了 65.04% 的用户
   *
   * @param nums
   * @return
   */
  public int[] exchange(int[] nums) {
    int i = 0, j = nums.length - 1, tmp;
    while (i < j) {
      while (i < j && (nums[i] & 1) == 1) i++;
      while (i < j && (nums[j] & 1) == 0) j--;
      tmp = nums[i];
      nums[i] = nums[j];
      nums[j] = tmp;
    }
    return nums;
  }
}
