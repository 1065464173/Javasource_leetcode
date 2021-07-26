package simple;

import org.junit.jupiter.api.Test;

/**
 * @program: Javasource_leetcode
 * @description: 给你两个二进制字符串，返回它们的和（用二进制表示）。 输入为 非空 字符串且只包含数字 1 和 0。
 * @author: Sxuet
 * @create: 2021-06-27 21:19
 */
public class AddBinary67 {
  @Test
  public void test01() {
    System.out.println(addBinary1("11", "1"));
    System.out.println(addBinary2("111", "1"));
  }

  /**
   * 使用Integer自带的方法 时间复杂度O(m+n) 最简单 但是如果字符串超333 位，不能转化为 Integer如果字符串 超过65 位，不能转化为
   * Long如果字符串超过500000001位，不能转化为 BigInteger
   *
   * @param a
   * @param b
   * @return toBinaryString
   */
  public String addBinary1(String a, String b) {
    return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
  }

  /**
   * @param a
   * @param b
   * @return
   */
  public String addBinary2(String a, String b) {
    StringBuilder ans = new StringBuilder();
    int ci = 0;
    int len = Math.max(a.length(), b.length());
    for (int i = 0; i < len; i++) {
      ci += (i < a.length()) ? (a.charAt(a.length() - 1 - i) - '0') : 0;
      ci += (i < b.length()) ? (b.charAt(b.length() - 1 - i) - '0') : 0;
      ans.append((char) (ci % 2 + '0'));
      ci /= 2;
    }
    if (ci > 0) {
      ans.append('1');
    }
    ans.reverse();
    return ans.toString();
  }
}
