package simple;

/**
 * @author Sxuet
 * @program Javasource_leetcode
 * @description 给定一个单词，你需要判断单词的大写使用是否正确。 我们定义，在以下情况时，单词的大写用法是正确的： 1.全部字母都是大写，比如"USA"。
 *     2、单词中所有字母都不是大写，比如"Leetcode"。 3.如果单词不只含有一个字母，只有首字母大写，比如"Google"。 否则，我们定义这个单词没有正确使用大写字母。
 * @since 2021-10-29 15:23
 */
public class DetectCapitalUse520 {
  /**
   * 正则表达式
   *
   * <p>执行用时： 10 ms , 在所有 Java 提交中击败了 5.12% 的用户 内存消耗： 38.6 MB , 在所有 Java 提交中击败了 5.12% 的用户
   *
   * @param word
   * @return
   */
  public boolean detectCapitalUse1(String word) {
    return word.matches("^(([A-Z]?[a-z]*)|[a-z]*|[A-Z]*)$");
  }

  /**
   * 执行用时： 1 ms , 在所有 Java 提交中击败了 99.47% 的用户 内存消耗： 36.5 MB , 在所有 Java 提交中击败了 96.12% 的用户
   *
   * @param word
   * @return
   */
  public boolean detectCapitalUse2(String word) {
    char[] cs = word.toCharArray();
    int upper = 0;
    int lower = 0;
    for (int i = 0; i < cs.length; i++) {
      if (cs[i] >= 'a') {
        lower++;
      } else {
        upper++;
      }
    }
    // 全大写
    if (upper == cs.length) {
      return true;
    }
    // 全小写
    if (lower == cs.length) {
      return true;
    }
    // 首字母大写
    if (upper == 1 && cs[0] < 'a') {
      return true;
    }
    return false;
  }
}
