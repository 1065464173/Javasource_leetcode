package cxymsjd6.simple;

import java.util.HashSet;
import java.util.stream.IntStream;

/**
 * @author Sxuet
 * @program daydayup
 * @description 实现一个算法，确定一个字符串的所有字符是否全都不同。
 * @since 2021-12-02 13:15
 */
public class IsUnique0101 {
  /**
   * hashset<br>
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 36.3 MB , 在所有 Java 提交中击败了 9.83% 的用户
   *
   * @param astr 给出字符串判断是否有重复字符出现
   * @return true 没有重复字符 / false 存在重复字符
   */
  public boolean isUnique1(String astr) {
    if (astr==null||astr.length()==0){
      return true;
    }
    HashSet<Character> set = new HashSet<>();
    for (int i = 0; i < astr.length(); i++) {
      if (!set.add(astr.charAt(i))) {
        return false;
      }
    }
    return true;
  }

  /**
   * 使用String原生方法indexOf，如果有重复字符，则同一个字符的indexOf和lastIndexOf的值不一样<br>
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 36.1 MB , 在所有 Java 提交中击败了 58.28% 的用户
   *
   * @param astr 给出字符串判断是否有重复字符出现
   * @return true 没有重复字符 / false 存在重复字符
   */
  public boolean isUnique2(String astr) {
    for (char c : astr.toCharArray()) {
      if (astr.indexOf(c)!=astr.lastIndexOf(c)){
        return false;
      }
    }
    return true;
  }
}
