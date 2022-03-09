package simple;

/**
 * @author Sxuet
 * @program Javasource_leetcode
 * @description 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * @since 2021-11-08 10:44
 */
public class ReverseWords557 {
  public static void main(String[] args) {

    System.out.println(reverseWords("Let's take LeetCode contest"));
  }

  public static String reverseWords(String s) {
    String[] s1 = s.split(" ");
    StringBuilder reverse = new StringBuilder();
    for (String s2 : s1) {
      StringBuilder subReverse = new StringBuilder(s2).reverse();
      reverse.append(subReverse).append(" ");
    }
    return reverse.toString().trim();
  }
}
