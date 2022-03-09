package simple;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @program: Javasource_leetcode
 * @description: 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * @author: Sxuet
 * @create: 2021-09-06 20:28
 */
public class FirstUniqChar387 {
  /**
   * 哈希表 <br>
   * 时间复杂度O（n）,空间复杂度：O（|Z|）
   *
   * <p>执行用时： 25 ms , 在所有 Java 提交中击败了 56.19% 的用户 内存消耗： 39 MB , 在所有 Java 提交中击败了 38.39% 的用户
   *
   * @param s
   * @return
   */
  public int firstUniqChar1(String s) {
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      Integer ans = map.getOrDefault(c, 0);
      map.put(c, ans + 1);
    }
    for (int i = 0; i < s.length(); ++i) {
      if (map.get(s.charAt(i)) == 1) {
        return i;
      }
    }
    return -1;
  }

  /**
   * 使用哈希表储存索引——对上个方法的改进 <br>
   * 时间复杂度O（n）,空间复杂度：O（|Z|）
   *
   * <p>具体地，对于哈希映射中的每一个键值对，键表示一个字符，值表示它的首次出现的索引（如果该字符只出现一次）或者-1（如果该字符出现多次）。当我们第一次遍历字符串时，设当前遍历到的字符为c，如果c不在哈希映射中，我们就将c与它的索引作为一个键值对加入哈希映射中，否则我们将c在哈希映射中对应的值修改为一1。
   * 在第一次遍历结束后，我们只需要再遍历一次哈希映射中的所有值，找出其中不为-1的最小值，即为第一个不重复字符的索引。如果哈希映射中的所有值均为-1，我们就返回-1。
   *
   * @param s
   * @return
   */
  public int firstUniqChar2(String s) {
    Map<Character, Integer> position = new HashMap<Character, Integer>();
    int n = s.length();

    for (int i = 0; i < n; ++i) {
      char ch = s.charAt(i);
      // 如果重复了设置value为-1，否则为该字符的位置i
      if (position.containsKey(ch)) {
        position.put(ch, -1);
      } else {
        position.put(ch, i);
      }
    }
    // 找到最小的索引值
    int first = n;
    for (Map.Entry<Character, Integer> entry : position.entrySet()) {
      int pos = entry.getValue();
      if (pos != -1 && pos < first) {
        first = pos;
      }
    }
    if (first == n) {
      first = -1;
    }
    return first;
  }

  /**
   * 队列<br>
   * 时间复杂度O（n）,空间复杂度：O（|Z|）<br>
   * 在维护队列时，我们使用了「延迟删除」这一技巧。也就是说，即使队列中有一些字符出现了超过一次，但它只要不位于队首，那么就不会对答案造成影响，我们也就可以不用去删除它。只有当它前面的所有字符被移出队列，它成为队首时，我们才需要将它移除。
   *
   * @param s
   * @return
   */
  public int firstUniqChar3(String s) {
    Map<Character, Integer> position = new HashMap<Character, Integer>();
    Queue<Pair> queue = new LinkedList<>();
    int n = s.length();

    for (int i = 0; i < n; ++i) {
      char ch = s.charAt(i);
      if (!position.containsKey(ch)) {
        position.put(ch, i);
        queue.offer(new Pair(ch, i));
      } else {
        position.put(ch, -1);
        while (!queue.isEmpty() && position.get(queue.peek().ch) == -1) {
          queue.poll();
        }
      }
    }
    return queue.isEmpty() ? -1 : queue.poll().pos;
  }

  class Pair {
    // 记录字符和位置
    char ch;
    int pos;

    Pair(char ch, int pos) {
      this.ch = ch;
      this.pos = pos;
    }
  }
}
