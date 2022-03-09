package simple;

/**
 * @program: Javasource_leetcode
 * @description: 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *     <p>字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *     <p>进阶：
 *     <p>如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 * @author: Sxuet
 * @create: 2021-09-09 21:31
 */
public class IsSubsequence392 {

  /**
   * 自创暴力解法——类似于官方的双指针<br>
   * 执行用时： 1 ms , 在所有 Java 提交中击败了 85.05% 的用户 内存消耗： 36.5 MB , 在所有 Java 提交中击败了 27.31% 的用户
   *
   * @param s
   * @param t
   * @return
   */
  public boolean isSubsequence1(String s, String t) {
    if (s.length() > t.length()) {
      return false;
    } else if (s.length() == t.length()) {
      return s.equals(t);
    }
    int j = 0;
    for (int i = 0; i < s.length(); i++) {
      boolean flag = false;
      for (; j < t.length(); j++) {
        if (s.charAt(i) == t.charAt(j)) {
          j++;
          flag = true;
          break;
        }
      }
      if (!flag) {
        return false;
      }
    }
    return true;
  }

  /**
   * 双指针 时间复杂度：O（n+m），空间复杂度：O(1)。 <br>
   * 执行用时： 1 ms , 在所有 Java 提交中击败了 85.05% 的用户 内存消耗： 36.5 MB , 在所有 Java 提交中击败了 26.18% 的用户
   *
   * @param s
   * @param t
   * @return
   */
  public boolean isSubsequence2(String s, String t) {
    if (s.length() > t.length()) {
      return false;
    } else if (s.length() == t.length()) {
      return s.equals(t);
    }
    int n = s.length(), m = t.length();
    int i = 0, j = 0;
    while (i < n && j < m) {
      if (s.charAt(i) == t.charAt(j)) {
        i++;
      }
      j++;
    }
    return i == n;
  }

  /**
   * 动态规划 时间复杂度：O（m x|Σ|+n）空间复杂度：O（mx|Σ|）
   *
   * <p>考虑前面的双指针的做法，我们注意到我们有大量的时间用于在t中找到下一个匹配字符。预处理出对于 t 的每一个位置
   * 我们可以使用动态规划的方法实现预处理，令f【i】【j】表示字符串t中从位置i开始往后字符j第一次出现的位置。在进行状态转移时，如果t中位置i的字符就是j，那么fi】【j】=i，否则j出现在位置i+1开始往后，即f【i】【j】=f【i+1】【j】，因此我们要倒过来进行动态规划，从后往前枚举i。
   *
   * <p>数据量大的情况下使用这种方法比较高效，低的话不太行。执行用时： 5 ms , 在所有 Java 提交中击败了 18.31% 的用户 内存消耗： 38.8 MB , 在所有 Java
   * 提交中击败了 5.06% 的用户
   *
   * @param s
   * @param t
   * @return
   */
  public boolean isSubsequence3(String s, String t) {
    // TODO: 看不懂=-=
    int n = s.length(), m = t.length();
    // dp数组f[i][j]表示字符串t以i位置开始第一次出现字符j的位置
    int[][] f = new int[m + 1][26];
    // 初始化边界条件，f[i][j] = m表示 t中不存在字符j
    for (int i = 0; i < 26; i++) {
      f[m][i] = m;
    }
    // 从后往前递推初始化f数组
    for (int i = m - 1; i >= 0; i--) {
      for (int j = 0; j < 26; j++) {
        if (t.charAt(i) == j + 'a') {
            f[i][j] = i;
        } else {
            f[i][j] = f[i + 1][j];
        }
      }
    }
    int add = 0;
    for (int i = 0; i < n; i++) {
      // t中没有s[i] 返回false
      if (f[add][s.charAt(i) - 'a'] == m) {
        return false;
      }
      // 否则直接跳到t中s[i]第一次出现的位置之后一位
      add = f[add][s.charAt(i) - 'a'] + 1;
    }
    return true;
  }
}
