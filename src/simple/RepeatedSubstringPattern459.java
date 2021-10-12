package simple;

import java.util.Arrays;

/**
 * @program: Javasource_leetcode
 * @description: 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 * @author: Sxuet
 * @create: 2021-09-30 13:38
 */
public class RepeatedSubstringPattern459 {
  /**
   * 枚举
   *
   * <p>时间复杂度：O（n2），其中n是字符串s的长度。枚举i的时间复杂度为O（n），遍历s的时间复杂度为O（n），相乘即为总时间复杂度。 空间复杂度：O（1）。
   *
   * <p>执行用时： 9 ms , 在所有 Java 提交中击败了 80.16% 的用户 内存消耗： 38.8 MB , 在所有 Java 提交中击败了 72.31% 的用户
   *
   * @param s
   * @return
   */
  public boolean repeatedSubstringPattern1(String s) {
    int n = s.length();
    for (int i = 1; i * 2 <= n; ++i) {
      if (n % i == 0) {
        boolean match = true;
        for (int j = i; j < n; ++j) {
          if (s.charAt(j) != s.charAt(j - i)) {
            match = false;
            break;
          }
        }
        if (match) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * 字符串匹配
   *
   * <p>执行用时： 82 ms , 在所有 Java 提交中击败了 39.53% 的用户 内存消耗： 39.1 MB , 在所有 Java 提交中击败了 10.10% 的用户
   *
   * @param s
   * @return
   */
  public boolean repeatedSubstringPattern2(String s) {
    return (s + s).indexOf(s, 1) != s.length();
  }

  /**
   * kmp
   *
   * <p>执行用时： 39 ms , 在所有 Java 提交中击败了 42.67% 的用户 内存消耗： 39 MB , 在所有 Java 提交中击败了 33.82% 的用户
   *
   * @param s
   * @return
   */
  public boolean repeatedSubstringPattern3(String s) {
    return kmp(s);
  }

  public boolean kmp(String pattern) {
    int n = pattern.length();
    int[] fail = new int[n];
    Arrays.fill(fail, -1);
    for (int i = 1; i < n; ++i) {
      int j = fail[i - 1];
      while (j != -1 && pattern.charAt(j + 1) != pattern.charAt(i)) {
        j = fail[j];
      }
      if (pattern.charAt(j + 1) == pattern.charAt(i)) {
        fail[i] = j + 1;
      }
    }
    System.out.println(Arrays.toString(fail));

    return fail[n - 1] != -1 && n % (n - fail[n - 1] - 1) == 0;
  }
}
