package cxymsjd6.simple;

import java.util.HashMap;

public class CompressString0106 {
  /**
   * 执行用时： 2 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 38.1 MB , 在所有 Java 提交中击败了 76.68% 的用户
   *
   * @param S
   * @return
   */
  public String compressString(String S) {
    if (S == null || S.length() == 0) {
      return S;
    }
    char[] chars = S.toCharArray();
    StringBuilder sb = new StringBuilder();
    int count = 1;
    for (int i = 1; i < chars.length; i++) {
      if (chars[i] == chars[i - 1]) {
        count++;
      } else {
        sb.append(chars[i - 1]).append(count);
        count = 1;
      }
    }
    sb.append(chars[chars.length - 1]).append(count);
    return sb.length() >= S.length() ? S : sb.toString();
  }
}
