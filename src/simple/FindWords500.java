package simple;

import java.util.ArrayList;

/**
 * @author Sxuet
 * @program Javasource_leetcode
 * @description 给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
 * @since 2021-10-26 10:40
 */
public class FindWords500 {
  /**
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 36.3 MB , 在所有 Java 提交中击败了 61.42% 的用户
   *
   * @param words
   * @return
   */
  public String[] findWords(String[] words) {
    // 每个字母所对应的键盘行数
    char[] keyborad =
        new char[] {2, 3, 3, 2, 1, 2, 2, 2, 1, 2, 2, 2, 3, 3, 1, 1, 1, 1, 2, 1, 1, 3, 1, 3, 1, 3};
    ArrayList<String> list = new ArrayList<>();
    for (String word : words) {
      String s = word.toLowerCase();
      int i = keyborad[word.toLowerCase().charAt(0) - 'a'];
      for (char c : s.toCharArray()) {
        if (i != keyborad[c - 'a']) {
          i = 0;
          break;
        }
      }
      if (i != 0) {
        list.add(word);
      }
    }
    return list.toArray(new String[0]);
  }
}
