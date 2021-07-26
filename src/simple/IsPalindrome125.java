package simple;

import java.util.Locale;

/**
 * @program: Javasource_leetcode
 * @description: 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *     <p>说明：本题中，我们将空字符串定义为有效的回文串。
 * @author: Sxuet
 * @create: 2021-07-14 22:08
 */
public class IsPalindrome125 {

  /**
   * 自己写的垃圾暴力解法
   *
   * @param s
   * @return
   */
  public boolean isPalindrome1(String s) {
    StringBuilder sb1 = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();
    String[] split = s.toLowerCase(Locale.ROOT).split("[^a-zA-Z0-9]*");
    for (int i = 0; i < split.length; i++) {
      sb2.append(split[i]);
    }
    String temp = sb2.toString();
    for (int i = temp.length() - 1; i >= 0; i--) {
      sb1.append(temp.charAt(i));
    }
    System.out.println("sb1" + sb1.toString());
    System.out.println("sb2" + sb2.toString());
    return sb1.toString().equals(sb2.toString());
  }

  /**
   * 筛选+遍历
   *
   * @param s
   * @return
   */
  public boolean isPalindrome2(String s) {
    StringBuilder sgood = new StringBuilder();
    int length = s.length();
    for (int i = 0; i < length; i++) {
      char ch = s.charAt(i);
      // 判断是否是数字或者字母
      if (Character.isLetterOrDigit(ch)) {
        sgood.append(Character.toLowerCase(ch));
      }
    }
    StringBuilder sgoodRev = new StringBuilder(sgood).reverse();
    return sgoodRev.toString().equals(sgood.toString());
  }

  /**
   * 双指针判断是否相同 当两个指针相遇时证明是回文
   *
   * <p>时间复杂符O(|s|) |s|字符串长度
   *
   * <p>空间复杂符O(|s|) 需要将所有的字母和数字存放到另一个字符串中，最坏情况下新串和原串完全相同。因此需要|s|的空间
   *
   * @param s
   * @return
   */
  public boolean isPalindrome3(String s) {
    StringBuilder sgood = new StringBuilder();
    int length = s.length();
    for (int i = 0; i < length; i++) {
      char ch = s.charAt(i);
      // 判断是否是数字或者字母
      if (Character.isLetterOrDigit(ch)) {
        sgood.append(Character.toLowerCase(ch));
      }
    }
    for (int i = 0, j = sgood.length() - 1; i <= j; i++, j--) {
      if (sgood.charAt(i) != sgood.charAt(j)) {
        return false;
      }
    }
    return true;
  }

  /**
   * 原串上直接判断 对上一种方法的优化，只使用O(1)的空间
   *
   * @param s
   * @return
   */
  public boolean isPalindrome4(String s) {
    int left = 0;
    int right = s.length() - 1;
    while (left < right) {
      while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
        ++left;
      }
      while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
        --right;
      }
      if (left < right) {
        if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
          return false;
        }
        ++left;
        --right;
      }
    }
    return true;
  }
}
