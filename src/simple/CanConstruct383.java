package simple;

/**
 * @program: Javasource_leetcode
 * @description: 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines
 *     里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 *     <p>(题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 * @author: Sxuet
 * @create: 2021-09-05 20:07
 */
public class CanConstruct383 {
  /**
   * 执行用时： 1 ms , 在所有 Java 提交中击败了 99.87% 的用户 内存消耗： 38.7 MB , 在所有 Java 提交中击败了 54.72% 的用户
   *
   * @param ransomNote
   * @param magazine
   * @return
   */
  public boolean canConstruct(String ransomNote, String magazine) {
    // 由于 ransomNote 和 magazine 都仅仅有小写字母，公用一份 help
    int[] help = new int[26];

    // 杂志加数量
    for (char c : magazine.toCharArray()) {
      ++help[c - 'a'];
    }

    // 赎金信减去数量
    for (char c : ransomNote.toCharArray()) {
      // 杂志字符数量不够时，返回 false
      if (--help[c - 'a'] < 0) {
        return false;
      }
    }
    return true;
  }
}
