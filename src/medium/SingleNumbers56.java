package medium;

/**
 * @author Sxuet
 * @program daydayup
 * @description 一个整型数组nums里除两个数字之外，其他数字都出现了两次。请写 程序找出这两个只出现一次的数字。要求时间复杂度是O（门），空间复杂度 是O（1）。
 * @since 2021-12-01 13:37
 */
public class SingleNumbers56 {
  /**
   * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 40.1 MB , 在所有 Java 提交中击败了 46.08% 的用户
   *
   * @param nums
   * @return
   */
  public int[] singleNumbers(int[] nums) {
    int ret = 0;
    for (int n : nums) {
      ret ^= n;
    }
    int div = 1;
    while ((div & ret) == 0) {
      div <<= 1;
    }
    int a = 0, b = 0;
    for (int n : nums) {
      if ((div & n) != 0) {
        a ^= n;
      } else {
        b ^= n;
      }
    }
    return new int[] {a, b};
  }
}
