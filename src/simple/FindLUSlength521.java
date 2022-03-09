package simple;

/**
 * @author Sxuet
 * @program Javasource_leetcode
 * @description 给你两个字符串，请你从这两个字符串中找出最长的特殊序列。 「最长特殊序列」定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。
 *     子序列可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。
 *     输入为两个字符串，输出最长特殊序列的长度。如果不存在，则返回-1。
 * @since 2021-11-01 10:37
 */
public class FindLUSlength521 {
  /**
   * 居然通过了 unbelievable<br>
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 36.1 MB , 在所有 Java 提交中击败了 74.64% 的用户
   *
   * @param a
   * @param b
   * @return
   */
  public int findLUSlength1(String a, String b) {
    return a.equals(b) ? -1 : Math.max(a.length(), b.length());
  }
}
