package simple;

/**
 * @program: Javasource_leetcode
 * @description: 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。 返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 单词
 *     是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * @author: Sxuet
 * @create: 2021-06-23 09:24
 */
public class LengthOfLastWord58 {
  public static void main(String[] args) {
    String s = "hello world";
    int i = lengthOfLastWord(s);
    System.out.println(s.substring(i + 1));
  }

  public static int lengthOfLastWord(String s) {
    int end = s.length() - 1;
    while (end > 0 && ' ' == s.charAt(end)) {
      end--;
    }
    int start = end;
    while (start > 0 && ' ' != s.charAt(start)) {
      start--;
    }
    return end - start;
  }
}
