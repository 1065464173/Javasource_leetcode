package simple;

/**
 * @program: Javasource_leetcode
 * @description: 给一个 非空 字符串 s 和一个单词缩写 abbr ，判断这个缩写是否可以是给定单词的缩写。
 *     <p>字符串 "word" 的所有有效缩写为：["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d",
 *     "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 *     注意单词"word"的所有有效缩写仅包含以上这些。任何其他的字符串都不是"word"的有效缩写。
 *     <p>注意: 假设字符串s仅包含小写字母且abbr 只包含小写字母和数字。
 * @author: Sxuet
 * @create: 2021-09-13 09:50
 */
public class ValidWordAbbreviation408 {

  /**
   * 判断给定缩写是否是给定单词的缩写，首先是要保证缩写还原回去以后的字符串长度等于单词的长度 <br>
   * 执行用时： 1 ms , 在所有 Java 提交中击败了 99.43% 的用户 内存消耗： 36.6 MB , 在所有 Java 提交中击败了 83.33% 的用户
   *
   * @param word
   * @param abbr
   * @return
   */
  public boolean validWordAbbreviation(String word, String abbr) {

    int len = abbr.length(), wordLen = word.length();
    int abbrLen = 0, num = 0;
    for (int i = 0; i < len; i++) {
      if (abbr.charAt(i) >= 'a' && abbr.charAt(i) <= 'z') {
        abbrLen += num + 1;
        num = 0;
        if (abbrLen > wordLen || abbr.charAt(i) != word.charAt(abbrLen - 1)) {
          return false;
        }
      } else {
        // 不能出现前导0
        if (num == 0 && abbr.charAt(i) == '0') {
          return false;
        }
        num = num * 10 + abbr.charAt(i) - '0';
      }
    }
    return abbrLen + num == wordLen;
  }
}
