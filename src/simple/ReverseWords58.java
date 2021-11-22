package simple;

/**
 * @author Sxuet
 * @program daydayup
 * @description 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am
 *     astudent."，则输出"student. a am I"。
 * @since 2021-11-22 10:24
 */
public class ReverseWords58 {
  /**
   * 双指针 <br>
   * 执行用时： 3 ms , 在所有 Java 提交中击败了 58.61% 的用户 内存消耗： 38.1 MB , 在所有 Java 提交中击败了 73.97% 的用户
   *
   * @param s
   * @return
   */
  public String reverseWords1(String s) {
    s = s.trim();
    int j = s.length() - 1, i = j;
    StringBuilder res = new StringBuilder();
    while (i >= 0) {
      // 搜索首个空格
      while (i >= 0 && s.charAt(i) != ' ') i--;
      // 添加单词
      res.append(s.substring(i + 1, j + 1) + " ");
      // 跳过单词间空格
      while (i >= 0 && s.charAt(i) == ' ') i--;
      // j 指向下个单词的尾字符
      j = i;
    }
    // 转化为字符串并返回
    return res.toString().trim();
  }

  /**
   * 使用split分割称数组后再倒序拼接<br>
   * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 38.4 MB , 在所有 Java 提交中击败了 28.91% 的用户
   *
   * @param s
   * @return
   */
  public String reverseWords2(String s) {
    String[] split = s.trim().split(" ");
    StringBuilder ans = new StringBuilder();
    for (int i = split.length - 1; i >= 0; i--) {
      if (split[i].equals("")) continue;
      ans.append(split[i]).append(" ");
    }
    return ans.toString().trim();
  }
}
