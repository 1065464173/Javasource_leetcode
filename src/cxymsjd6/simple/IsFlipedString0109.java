package cxymsjd6.simple;

/**
 * @author Sxuet
 * @program daydayup
 * @description 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）
 * @since 2021-12-20 14:25
 */
public class IsFlipedString0109 {
  /**
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 37.9 MB , 在所有 Java 提交中击败了 88.11% 的用户
   *
   * @param s1
   * @param s2
   * @return
   */
  public boolean isFlipedString(String s1, String s2) {
    String s = s1 + s1;
    return s.contains(s2) && s1.length() == s2.length();
  }
}
