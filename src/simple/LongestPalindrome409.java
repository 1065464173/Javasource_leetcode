package simple;

import java.util.HashMap;

/**
 * @program: Javasource_leetcode
 * @description:
 * @author: Sxuet
 * @create: 2021-09-13 11:24
 */
public class LongestPalindrome409 {
  /**
   * 自己写的哈希表，易得回文的最多只有一个奇数个数的字符，其余都出现偶数此 <br>
   * 记录每个字符出现的次数，若次数大于2，则记录回文长度+2； <br>
   * 时间复杂度O(n) 空间O(n) 存放字符串每个元素出现次数
   *
   * @param s
   * @return
   */
  public int longestPalindrome1(String s) {
    int ans = 0;
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      Integer cval = map.get(c);
      cval += cval == null ? 1 : cval + 1;
      if (cval > 1) {
        cval -= 2;
        ans += 2;
      }
      map.put(c, cval);
    }
    if (map.containsValue(1)) {
      ans++;
    }
    return ans;
  }

  /**
   * 官方的贪心算法，和我的算法差不多 时间复杂度：O（N），其中N为字符串s的长度。我们 s 需要遍历每个字符一次。
   * 空间复杂度：O（S），其中S为字符集大小。在Java代码中，我们使用了一个长度为128的数组，存储每个字符出现的次数，这是因为字符的ASCI值的范围为【0，128）。而由于题目中保证了给定的字符串s只包含大
   *
   * @param s
   * @return
   */
  public int longestPalindrome2(String s) {
    // 字符集为128大小
    int[] count = new int[128];
    int length = s.length();
    for (int i = 0; i < length; ++i) {
      char c = s.charAt(i);
      count[c]++;
    }

    int ans = 0;
    for (int v : count) {
      ans += v / 2 * 2;
      if (v % 2 == 1 && ans % 2 == 0) {
        ans++;
      }
    }
    return ans;
  }
}
