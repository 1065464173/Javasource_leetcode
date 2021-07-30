package simple;

import java.util.Arrays;

/**
 * @program: Javasource_leetcode
 * @description: 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *     <p>注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词
 * @author: Sxuet
 * @create: 2021-08-11 21:07
 */
public class IsAnagram {
  /**
   * 排序
   *
   * <p>时间复杂度： O(nlogn) 为排序时间复杂 n为s的长度，比较两个字符串是否相等需要O(n) <br>
   * 空间复杂度：O(logn) 排序需要<br>
   * 执行用时： 3 ms , 在所有 Java 提交中击败了 82.40% 的用户 内存消耗： 38.3 MB , 在所有 Java 提交中击败了 89.60% 的用户
   *
   * @param s
   * @param t
   * @return
   */
  public boolean isAnagram1(String s, String t) {
    // 长度不相等直接返回false
    if (s.length() != t.length()) {
      return false;
    }
    char[] str1 = s.toCharArray();
    char[] str2 = t.toCharArray();
    Arrays.sort(str1);
    Arrays.sort(str2);
    return Arrays.equals(str1, str2);
  }

  /**
   * 哈希表
   *
   * <p>时间O(n) n 为s长度 空间O(s) s为字符集大小，这里s=26<br>
   * 执行用时： 2 ms , 在所有 Java 提交中击败了 94.97% 的用户 内存消耗： 38.5 MB , 在所有 Java 提交中击败了 72.39% 的用户
   *
   * @param s
   * @param t
   * @return
   */
  public boolean isAnagram2(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    int length = s.length();
    int[] count = new int[26];
    for (int i = 0; i < length; i++) {
      count[s.charAt(i) - 'a']++;
    }
    for (int i = 0; i < length; i++) {
      if (count[t.charAt(i) - 'a']-- < 0) {
        return false;
      }
    }
    return true;
  }
}
