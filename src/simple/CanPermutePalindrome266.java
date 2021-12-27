package simple;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: Javasource_leetcode
 * @description: 给定一个字符串，判断该字符串中是否可以通过重新排列组合，形成一个回文字符串。
 * @author: Sxuet
 * @create: 2021-08-18 21:22
 */
public class CanPermutePalindrome266 {
  /**
   * 自创 时间O(2|S|) 空间 O(128)
   *
   * <p>观察回文数会发现，字符长度为偶数的时候，每个字符的出现次数为2。<br>
   * 字符长度为奇数的时候，则只有一个字符的出现次数为奇数次
   *
   * @param s
   * @return
   */
  public boolean canPermutePalindrome1(String s) {
    // 定义一个计数数组，对每个字母出现的次数计数
    int[] count = new int[128];
    // 遍历String的每个字符，记录出现次数到计数数组
    for (int i = 0; i < s.length(); i++) {
      count[s.charAt(i) - 'a']++;
    }
    // flag记录出现字符次数为计数个的字符数
    int flag = 0;
    for (int i = 0; i < count.length; i++) {
      if (count[i] % 2 == 1) {
        flag++;
      }
    }
    // 如果出现字符次数为计数个的字符数大于2，则必不是回文数
    return flag < 2;
  }

  /**
   * 官方的穷举判断，判断思路和我们自创的一样——出现奇数次的字符的数量不能超过 1
   *
   * <p>由于字符串中出现的字符的 ASCII 码在 0 到 127 之间，因此我们可以枚举所有的字符，对于每一个字符 c，我们找出它在字符串中出现的次数 ct，如果 ct
   * 为奇数，那么我们将计数器 count 的值增加 1。
   *
   * <p>时间复杂度： O(128∗∣S∣)。我们枚举了 128 个字符，每次枚举需要遍历整个字符串，因此时间复杂度为 O(128∗∣S∣)。<br>
   * 空间复杂度:O(1)。
   *
   * @param s
   * @return
   */
  public boolean canPermutePalindrome2(String s) {
    int count = 0;
    for (char i = 0; i < 128 && count <= 1; i++) {
      int ct = 0;
      for (int j = 0; j < s.length(); j++) {
        if (s.charAt(j) == i) {
          ct++;
        }
      }
      count += ct % 2;
    }
    return count <= 1;
  }

  /**
   * 基于hash表的映射，思路仍然一样
   *
   * <p>时间复杂度O(|S|) 空间复杂度O(min{|S|,128})
   *
   * @param s
   * @return
   */
  public boolean canPermutePalindrome3(String s) {
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
    }
    int count = 0;
    for (char key : map.keySet()) {
      count += map.get(key) % 2;
    }
    return count <= 1;
  }

  /**
   * 数组+单次循环
   *
   * <p>时间O(|S|) 空间O(128)
   *
   * @param s
   * @return
   */
  public boolean canPermutePalindrome4(String s) {
    int[] map = new int[128];
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      map[s.charAt(i)]++;
      if (map[s.charAt(i)] % 2 == 0) {
          count--;
      } else {
          count++;
      }
    }
    return count <= 1;
  }

  /**
   * 方法四也可以使用集合而不是数组来实现
   *
   * <p>时间复杂度O(|S|) 空间复杂度O(min{|S|,128})
   *
   * @param s
   * @return
   */
  public boolean canPermutePalindrome5(String s) {
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      if (!set.add(s.charAt(i))) {
          set.remove(s.charAt(i));
      }
    }
    return set.size() <= 1;
  }
}
