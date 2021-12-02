package cxymsjd6.simple;

import liquibase.pro.packaged.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Sxuet
 * @program daydayup
 * @description 给定两个字符串s1和s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * @since 2021-12-02 13:50
 */
public class CheckPermutation0102 {
  /**
   * hashmap存储 遍历两次<br>
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 36.2 MB , 在所有 Java 提交中击败了 30.53% 的用户
   *
   * @param s1 字符串1
   * @param s2 字符串2
   * @return 两个字符串重排后是否相等（无序元素是否相等）
   */
  public boolean checkPermutation1(String s1, String s2) {
    if (s1 == null || s2 == null || s1.length() != s2.length()) {
      return false;
    }
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s1.length(); i++) {
      char c = s1.charAt(i);
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    for (int i = 0; i < s2.length(); i++) {
      char c = s2.charAt(i);
      Integer integer = map.get(c);
      if (integer == null || integer < 1) {
        return false;
      }
      map.put(c, integer - 1);
    }
    return true;
  }

  /**
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 36.1 MB , 在所有 Java 提交中击败了 50.97% 的用户
   *
   * @param s1
   * @param s2
   * @return
   */
  public boolean checkPermutation2(String s1, String s2) {
    if (s1 == null || s2 == null || s1.length() != s2.length()) {
      return false;
    }
    char[] chars1 = s1.toCharArray();
    char[] chars2 = s2.toCharArray();
    Arrays.sort(chars1);
    Arrays.sort(chars2);
    /*return new String(chars1).equals(new String(chars2));*/
    return Arrays.equals(chars1,chars2);
  }
}
