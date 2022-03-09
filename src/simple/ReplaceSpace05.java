package simple;

/**
 * @author Sxuet
 * @program daydayup
 * @description 请实现一个函数，把字符串s中的每个空格替换成"%20"。
 * @since 2021-11-12 10:23
 */
public class ReplaceSpace05 {
  /**
   * 遍历一遍替换，使用StringBuilder更有效率<br>
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 36.2 MB , 在所有 Java 提交中击败了 56.02% 的用户
   *
   * @param s
   * @return
   */
  public String replaceSpace1(String s) {
    StringBuilder ans = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == ' ') {
        ans.append("%20");
      } else {
        ans.append(c);
      }
    }
    return ans.toString();
  }

  /**
   * 正则表达式 效率慢
   *
   * @param s
   * @return
   */
  public String replaceSpace2(String s) {
    return s.replaceAll(" ", "%20");
  }
}
