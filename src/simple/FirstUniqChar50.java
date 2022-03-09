package simple;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author Sxuet
 * @program daydayup
 * @description 在字符串s中找出第一个只出现一次的字符。如果没有，返回一个单空格。s只包含小写字母。
 * @since 2021-11-14 20:04
 */
public class FirstUniqChar50 {
  public char firstUniqChar(String s) {
    char ans = '\0';
    for (int i = 0; i < s.length(); i++) {
      ans += s.charAt(i);
    }
    return ans;
  }

  /**
   * 使用hashmap效率偏低<br>
   * 执行用时： 25 ms , 在所有 Java 提交中击败了 39.32% 的用户 内存消耗： 39 MB , 在所有 Java 提交中击败了 5.09% 的用户
   *
   * @param s
   * @return
   */
  public char firstUniqChar2(String s) {
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      map.put(c, map.getOrDefault(c, 0) + 1);
      if (map.get(c) == 1) {
        return c;
      }
    }
    return ' ';
  }

  /**
   * 执行用时： 25 ms , 在所有 Java 提交中击败了 39.32% 的用户 内存消耗： 38.7 MB , 在所有 Java 提交中击败了 41.42% 的用户
   *
   * @param s
   * @return
   */
  public char firstUniqChar3(String s) {
    Queue<Pair> queue = new LinkedList<>();
    int length = s.length();
    Map<Character, Integer> position = new HashMap<Character, Integer>(length);
    for (int i = 0; i < length; i++) {
      char c = s.charAt(i);
      // 如果没有记录过字符，记录到map并且添加到队列；
      // 如果已经记录过，则将map中的位置设为-1，
      if (!position.containsKey(c)) {
        position.put(c, i);
        queue.offer(new Pair(c, i));
      } else {
        position.put(c, -1);
        while (!queue.isEmpty() && position.get(queue.peek().ch) == -1) {
          queue.poll();
        }
      }
    }
    return queue.isEmpty() ? ' ' : queue.poll().ch;
  }
}

class Pair {
  char ch;
  int pos;

  Pair(char ch, int pos) {
    this.ch = ch;
    this.pos = pos;
  }
}
