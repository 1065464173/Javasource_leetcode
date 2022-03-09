package simple;

/**
 * @program: JavaSE_learning
 * @description: 给你两个字符串haystack 和 needle 请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。
 *     如果不存在，则返回 -1 。
 * @author: Sxuet
 * @create: 2021-06-13 13:58
 */
public class StrStr28 {
  public static void main(String[] args) {
    String haystack = "hello";
    String needle = "el";
    //        System.out.println(strStr1(haystack, needle));
    int index = strStr2(haystack, needle);
    System.out.println(index);
  }

  public static int strStr2(String haystack, String needle) {
    /**
     * @description: KMP解法 时间复杂符O(m+n) 空间复杂度O(1)
     * @param: [haystack, needle]
     * @return: int
     * @author: Sxuet
     * @date: 2021/6/13 2:16 下午
     */

    /**
     * int n = haystack.length(), m = needle.length(); if (m == 0) { return 0; } int[] pi = new
     * int[m]; for (int i = 1, j = 0; i < m; i++) { while (j > 0 && needle.charAt(i) !=
     * needle.charAt(j)) { j = pi[j - 1]; } if (needle.charAt(i) == needle.charAt(j)) { j++; } pi[i]
     * = j; } for (int i = 0, j = 0; i < n; i++) { while (j > 0 && haystack.charAt(i) !=
     * needle.charAt(j)) { j = pi[j - 1]; } if (haystack.charAt(i) == needle.charAt(j)) { j++; } if
     * (j == m) { return i - m + 1; } } return -1;
     */
    char[] s = haystack.toCharArray();
    char[] p = needle.toCharArray();
    int n = haystack.length();
    int m = needle.length();
    int[] next = new int[m + 1];

    next[1] = 0;
    // next 下标
    int i = 1;
    // j当前比较项指针
    int j = 0;
    while (i < m) {
      if (j == 0 || p[i] == p[j]) {
        next[++i] = ++j;
      } else {
        j = next[j];
      }
    }

    // 匹配过程，i = 1，j = 0 开始，i 小于等于原串长度 【匹配 i 从 1 开始】
    for (i = 1, j = 0; i <= n; i++) {
      // 匹配成功的话，先让 j++，结束本次循环后 i++
      if (s[i - 1] == p[j]) {
        j++;
      } else {
        j = next[j];
      }
      // 整一段匹配成功，直接返回下标
      if (j == m) {
        return i - m;
      }
    }

    return -1;
  }

  public static int strStr1(String haystack, String needle) {
    /**
     * @description: 暴力算法 时间复杂度O(n*m) 空间复杂度O(1)L
     * @param: [haystack, needle]
     * @return: int
     * @author: Sxuet
     * @date: 2021/6/13 2:09 下午
     */
    int n = haystack.length(), m = needle.length();
    if (needle.length() == 0 || haystack.length() == 0) {
      return 0;
    }
    for (int i = 0; i + m <= n; i++) {
      boolean flag = true;
      for (int j = 0; j < m; j++) {
        if (haystack.charAt(i + j) != needle.charAt(j)) {
          flag = false;
          break;
        }
      }
      if (flag) {
        return i;
      }
    }
    return -1;
  }
}
