package cxymsjd6.simple;

import liquibase.pro.packaged.C;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Sxuet
 * @program daydayup
 * @description 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。 回文串不一定是字典当中的单词。
 * @since 2021-12-02 16:02
 */
public class CanPermutePalindrome0104 {
  /**
   * 使用hashmap判断 字符串中字符个数为基数的个数是否超过2，如果超过2则必构不成回文串<br>
   * 执行用时： 1 ms , 在所有 Java 提交中击败了 43.46% 的用户 内存消耗： 36.1 MB , 在所有 Java 提交中击败了 62.95% 的用户
   *
   * @param s
   * @return
   */
  public boolean canPermutePalindrome1(String s) {
    if (s == null || s.length() == 0) {
      return false;
    }
    HashMap<Character, Integer> map = new HashMap<>(s.length());
    int odd = 0;
    char[] chars = s.toCharArray();
    for (char c :chars ) {
      Integer cVal = map.getOrDefault(c, 0);
      odd += (cVal++ & 1) == 0 ? 1 : -1;
      map.put(c, cVal);
    }
    return odd < 2;
  }

  /**
   * 使用set 更快且更简洁，也不用记录每个字符出现的个数<br>
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 36.1 MB , 在所有 Java 提交中击败了 70.98% 的用户
   *
   * @param s
   * @return
   */
  public boolean canPermutePalindrome2(String s) {
    if (s == null) {
      return false;
    }
    char[] chars = s.toCharArray();
    Set<Character> set = new HashSet<>();
    for (char c : chars) {
      if (set.contains(c)) {
        set.remove(c);
      } else {
        set.add(c);
      }
    }
    return set.size() < 2;
  }
}
