package simple;

import java.util.HashMap;

/**
 * @program: Javasource_leetcode
 * @description: 给定两个字符串s和t，判断它们是否是同构的。
 *     <p>如果s中的字符可以按某种映射关系替换得到t，那么这两个字符串是同构的。
 *     <p>每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 * @author: Sxuet
 * @create: 2021-07-31 09:34
 */
public class IsIsomorphic205 {
  /**
   * 哈希表。 由于必须维护双射关系。因此维护两个哈希表
   *
   * <p>时间复杂度：O(n)，其中 n 为字符串的长度。我们只需同时遍历一遍字符串 s 和 t 即可。 <br>
   * 空间复杂度 O(∣Σ∣)，其中 Σ 是字符串的字符集。哈希表存储字符的空间取决于字符串的字符集大小，最坏情况下每个字符均不相同，需要O(∣Σ∣) 的空间。
   *
   * @param s
   * @param t
   * @return
   */
  public boolean isIsomorphic(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    HashMap<Character, Character> s2t = new HashMap<>();
    HashMap<Character, Character> t2s = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char x = s.charAt(i), y = t.charAt(i);
      if ((s2t.containsKey(x) && s2t.get(x) != y) || (t2s.containsKey(y) && t2s.get(y) != x)) {
        return false;
      }
      s2t.put(x, y);
      t2s.put(y, x);
    }
    return true;
  }
}
