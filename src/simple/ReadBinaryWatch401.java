package simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Javasource_leetcode
 * @description: 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。每个 LED 代表一个 0 或 1，最低位在右侧。
 *     给你一个整数 turnedOn ，表示当前亮着的 LED 的数量，返回二进制手表可以表示的所有可能时间。你可以 按任意顺序 返回答案。
 *     <p>小时不会以零开头：
 *     <p>例如，"01:00" 是无效的时间，正确的写法应该是 "1:00" 。 分钟必须由两位数组成，可能会以零开头：
 *     <p>例如，"10:2" 是无效的时间，正确的写法应该是 "10:02" 。
 * @author: Sxuet
 * @create: 2021-09-09 22:17
 */
public class ReadBinaryWatch401 {
  /**
   * 枚举法 时间复杂度： O(1)，空间复杂度：O（1）| <br>
   * 执行用时： 10 ms , 在所有 Java 提交中击败了 79.39% 的用户 内存消耗： 38.7 MB , 在所有 Java 提交中击败了 13.03% 的用户
   *
   * @param turnedOn
   * @return
   */
  public List<String> readBinaryWatch1(int turnedOn) {
    List<String> ans = new ArrayList<String>();
    for (int h = 0; h < 12; ++h) {
      for (int m = 0; m < 60; ++m) {
        if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
          ans.add(h + ":" + (m < 10 ? "0" : "") + m);
        }
      }
    }
    return ans;
  }

  /**
   * 二进制枚举 枚举所有2^10=1024种灯的开闭组合 时间复杂度：0（1）。空间复杂度：O(1)。 <br>
   * 执行用时： 10 ms , 在所有 Java 提交中击败了 79.39% 的用户 内存消耗： 37.3 MB , 在所有 Java 提交中击败了 69.80% 的用户
   *
   * @param turnedOn
   * @return
   */
  public List<String> readBinaryWatch2(int turnedOn) {
    List<String> ans = new ArrayList<String>();
    for (int i = 0; i < 1024; ++i) {
      // 用位运算取出高 4 位和低 6 位
      int h = i >> 6, m = i & 63;
      if (h < 12 && m < 60 && Integer.bitCount(i) == turnedOn) {
        ans.add(h + ":" + (m < 10 ? "0" : "") + m);
      }
    }
    return ans;
  }
}
