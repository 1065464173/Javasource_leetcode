package simple;

/**
 * @program: Javasource_leetcode
 * @description: 给定两个字符串 s 和 t，它们只包含小写字母。
 *     <p>字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *     <p>请找出在 t 中被添加的字母。
 * @author: Sxuet
 * @create: 2021-09-07 22:33
 */
public class FindTheDifference389 {
  /**
   * 自己写的位运算！棒棒哦～<br>
   * 看了其他答案有计数法，ascii码求和法 还是位运算最好<br>
   * 时间复杂度：O（N）。空间复杂度：O（1）。 <br>
   * 执行用时： 1 ms , 在所有 Java 提交中击败了 99.42% 的用户 内存消耗： 36.5 MB , 在所有 Java 提交中击败了 94.41% 的用户 执行用时： 2 ms ,
   *
   * @param s
   * @param t
   * @return
   */
  public char findTheDifference(String s, String t) {

    int length = s.length();
    char add = '\u0000';
    for (int i = 0; i < length; i++) {
      add ^= s.charAt(i);
      add ^= t.charAt(i);
    }
    add ^= t.charAt(length);

    return add;
  }
}
