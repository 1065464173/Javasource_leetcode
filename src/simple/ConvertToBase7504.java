package simple;

/**
 * @author Sxuet
 * @program Javasource_leetcode
 * @description 给定一个整数num，将其转化为7进制，并以字符串形式输出。
 * @since 2021-10-27 14:27
 */
public class ConvertToBase7504 {
  /**
   * 执行用时： 1 ms , 在所有 Java 提交中击败了 85.86% 的用户 内存消耗： 35.9 MB , 在所有 Java 提交中击败了 41.45% 的用户
   *
   * @param num
   * @return
   */
  public String convertToBase7(int num) {
    if (num == 0) {
      return "0";
    }
    boolean isNeg = num < 0;
    StringBuilder sb = new StringBuilder();
    num = Math.abs(num);
    while (num > 0) {
      sb.append(num % 7);
      num /= 7;
    }
    if (isNeg) {
      sb.append("-");
    }
    return sb.reverse().toString();
  }
}
