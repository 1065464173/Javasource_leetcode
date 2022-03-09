package simple;

/**
 * @program: Javasource_leetcode
 * @description: 有一个密钥字符串S，只包含字母，数字以及'-'（破折号）。其中，N个‘-'将字符串分成了N+1组。
 *     给你一个数字K，请你重新格式化字符串，使每个分组恰好包含K个字符。特别地，第一个分组包含的字符个数必须小于等于K，但至少要包含1个字符。两个分组之间需要用'-'（破折号）隔开，并且将所有的小写字母转换为大写字母。
 *     给定非空字符串S和数字K，按照上面描述的规则进行格式化。
 * @author: Sxuet
 * @create: 2021-10-17 20:19
 */
public class LicenseKeyFormatting482 {
  /**
   * 暴力解法：去除字符串中所有'-'，再根据k的值从尾到头开始添加'-'<br>
   * 执行用时： 63 ms , 在所有 Java 提交中击败了 11.93% 的用户 内存消耗： 39 MB , 在所有 Java 提交中击败了 17.43% 的用户
   *
   * @param s
   * @param k
   * @return
   */
  public String licenseKeyFormatting1(String s, int k) {
    String str = s.replaceAll("-?", "");
    StringBuilder sb = new StringBuilder(str.toUpperCase());

    for (int i = str.length() - k; i > 0; i -= k) {
      sb.insert(i, '-');
    }
    return sb.toString();
  }

  /**
   * 评论区解法，和我的差不多，一些细节的处理，比我的快<br>
   * 执行用时： 44 ms , 在所有 Java 提交中击败了 21.92% 的用户 内存消耗： 38.5 MB , 在所有 Java 提交中击败了 55.21% 的用户
   *
   * @param s
   * @param k
   * @return
   */
  public String licenseKeyFormatting2(String s, int k) {
    StringBuilder sb = new StringBuilder();
    for (char c : s.toCharArray()) {
      if (c == '-') {
        continue;
      }
      sb.append((c >= 'a' && c <= 'z') ? (char) (c - 32) : c);
    }
    int len = sb.length() - k;
    while (len > 0) {
      sb.insert(len, "-");
      len -= k;
    }
    return sb.toString();
  }

  /**
   * 官方解答：取出所有不为破折号的字符，从字符串 s 的末尾开始往前取出字符构建新的字符串 ans每次取出字符时首先判断该字符是否为破折号，如果为破折号则跳过；否则将当前的字符计数 cnt 加
   * 1，同时检查如果当前字符为小写字母则将其转化为大写字母，将当前字符加入到字符串 ans 的末尾。
   * 对字符进行计数时，每隔k个字符就在字符串ans中添加一个破折号。特殊情况需要处理，字符串ans的最后一个字符为破折号则将其去掉。 我们对已经构建的字符串ans进行反转即为返回结果。 <br>
   * 执行用时： 9 ms , 在所有 Java 提交中击败了 83.68% 的用户 内存消耗： 38.7 MB , 在所有 Java 提交中击败了 28.84% 的用户
   *
   * @param s
   * @param k
   * @return
   */
  public String licenseKeyFormatting3(String s, int k) {
    StringBuilder ans = new StringBuilder();
    int cnt = 0;

    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) != '-') {
        cnt++;
        ans.append(Character.toUpperCase(s.charAt(i)));
        if (cnt % k == 0) {
          ans.append("-");
        }
      }
    }
    if (ans.length() > 0 && ans.charAt(ans.length() - 1) == '-') {
      ans.deleteCharAt(ans.length() - 1);
    }
    return ans.reverse().toString();
  }
}
