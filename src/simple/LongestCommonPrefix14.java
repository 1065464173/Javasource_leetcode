package simple;

/**
 * @Author: Sxuet @Date: 2021-06-06 21:11:13 @LastEditTime: 2021-06-06 22:35:39 @LastEditors:
 * Sxuet @FilePath: /JavaSE_learning/Javasource_leetcode/LongestCommonPrefix14.java @Description:
 * 编写一个函数来查找字符串数组中的最长公共前缀。 如果不存在公共前缀，返回空字符串 ""。
 */
public class LongestCommonPrefix14 {
  public static void main(String[] args) {
    String[] strings = {"hahahah", "hahahahha", "hahah", "ahahah"};
    String commonStr = longestCommonPrefix1(strings);
    System.out.println(commonStr);
  }

  public static String longestCommonPrefix1(String[] strs) {
    if (strs.length == 0 || strs == null) {
      return "";
    }
    String prefix = strs[0];
    for (int i = 1; i < strs.length; i++) {
      prefix = longestCommonPrefix1(prefix, strs[i]);
      if (prefix.length() == 0) {
        break;
      }
    }
    return prefix;
  }

  public static String longestCommonPrefix1(String prefix, String str) {
    int length = Math.min(prefix.length(), str.length());
    int index = 0;
    while (index < length && str.charAt(index) == prefix.charAt(index)) {
      index++;
    }
    return prefix.substring(0, index);
  }
}
