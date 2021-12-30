package difficult;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Sxuet
 * @program daydayup
 * @description
 *     请实现一个函数用来匹配包含'。·和'*'的正则表达式。模式中的字符。表示任意一个字符，而*表示它前面的字符可以出现任意次（含次）。在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa
 *     ”与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 * @since 2021-12-08 20:47
 */
public class IsMatch19 {
  /**
   * 喂，这是困难题！！不是让你投机取巧！！！<br>
   * 执行用时： 37 ms , 在所有 Java 提交中击败了 10.28% 的用户 内存消耗： 38.6 MB , 在所有 Java 提交中击败了 6.25% 的用户
   *
   * @param s
   * @param p
   * @return
   */
  public boolean isMatch1(String s, String p) {
    return s.matches(p);
  }

  /**
   * 动态规划 - 转移方程 <br>
   * 执行用时： 5 ms , 在所有 Java 提交中击败了 34.11% 的用户 内存消耗： 38.3 MB , 在所有 Java 提交中击败了 32.81% 的用户
   *
   * @param s
   * @param p
   * @return
   */
  public boolean isMatch2(String s, String p) {
    int m = s.length();
    int n = p.length();

    //f[i][j] 代表A的前i个和B的前j个能否匹配
    boolean[][] f = new boolean[m + 1][n + 1];
    f[0][0] = true;
    for (int i = 0; i <= m; ++i) {
      for (int j = 1; j <= n; ++j) {
        if (p.charAt(j - 1) == '*') {
          f[i][j] = f[i][j - 2];
          if (matches(s, p, i, j - 1)) {
            f[i][j] = f[i][j] || f[i - 1][j];
          }
        } else {
          if (matches(s, p, i, j)) {
            f[i][j] = f[i - 1][j - 1];
          }
        }
      }
    }
    return f[m][n];
  }

  public boolean matches(String s, String p, int i, int j) {
    if (i == 0) {
      return false;
    }
    if (p.charAt(j - 1) == '.') {
      return true;
    }
    return s.charAt(i - 1) == p.charAt(j - 1);
  }
}
