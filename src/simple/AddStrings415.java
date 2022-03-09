package simple;

/**
 * @program: Javasource_leetcode
 * @description:
 * @author: Sxuet
 * @create: 2021-09-17 10:14
 */
public class AddStrings415 {
  /**
   * 模拟进位 <br>
   * 时间复杂度：O（max（len，len2） 空间复杂度：O（1）
   *
   * @param num1
   * @param num2
   * @return
   */
  public String addStrings(String num1, String num2) {
    StringBuilder ans = new StringBuilder();
    int n1 = num1.length() - 1;
    int n2 = num2.length() - 1;
    // 记录进位
    int c = 0;
    while (n1 >= 0 || n2 >= 0) {
      // 记录两个低位相加的和
      int i = 0;
      if (n1 >= 0) {
        i += num1.charAt(n1--) - '0';
      }
      if (n2 >= 0) {
        i += num2.charAt(n2--) - '0';
      }
      i += c;
      c = i / 10;
      ans.append(i % 10);
    }
    if (c > 0) {
      ans.append(c);
    }
    return ans.reverse().toString();
  }
}
