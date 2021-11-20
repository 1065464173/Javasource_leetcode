package medium;

import java.util.HashSet;

/**
 * @author Sxuet
 * @program daydayup
 * @description 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * @since 2021-11-19 17:17
 */
public class LengthOfLongestSubstring48 {
  /**
   * 动态规划<br>
   * 1.定义状态:dp【j】代表以字符s【j】结尾的“最长不重复子字符串”的长度。 <br>
   * 2.转移方程：固定右边界j，设字符s【j】左边距离最近的相同字符为s【i】，即s【i】=s【j】。 <br>
   * 返回值：max（dp），即全局的“最长不重复子字符串”的长度。<br>
   * 执行用时： 5 ms , 在所有 Java 提交中击败了 64.85% 的用户 内存消耗： 38.4 MB , 在所有 Java 提交中击败了 53.39% 的用户
   *
   * @param s
   * @return
   */
  public int lengthOfLongestSubstring(String s) {
    int left = 0, right = 0, ans = 0;
    HashSet<Character> set = new HashSet<>();
    while (left <= right && right < s.length()) {
      char c = s.charAt(right++);
      if (!set.add(c)) {
        ans = Math.max(set.size(), ans);
        while (true) {
          char c1 = s.charAt(left++);
          if (c1 == c) {
            break;
          }
          set.remove(c1);
        }
      }
    }
    ans = Math.max(set.size(), ans);

    return ans;
  }
}
