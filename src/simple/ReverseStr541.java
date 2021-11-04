package simple;

/**
 * @author Sxuet
 * @program Javasource_leetcode
 * @description 给定一个字符串s和一个整数k，从字符串开头算起，每计数至2k个字符，就反转这2k字符中的前k个字符。 。如果剩余字符少于k个，则将剩余字符全部反转。
 *     如果剩余字符小于2k但大于或等于k个，则反转前k个字符，其余字符保持原样。
 * @since 2021-11-04 09:44
 */
public class ReverseStr541 {

  /**
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 38.6 MB , 在所有 Java 提交中击败了 26.75% 的用户
   *
   * @param s
   * @param k
   * @return
   */
  public String reverseStr1(String s, int k) {
    int n = s.length();
    char[] arr = s.toCharArray();
    for (int i = 0; i < n; i += 2 * k) {
      reverse(arr, i, Math.min(i + k, n) - 1);
    }
    return new String(arr);
  }

  public void reverse(char[] arr, int left, int right) {
    while (left < right) {
      char temp = arr[left];
      arr[left] = arr[right];
      arr[right] = temp;
      left++;
      right--;
    }
  }
}
