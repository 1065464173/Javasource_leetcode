package simple;

import java.util.Arrays;

/**
 * @program: Javasource_leetcode
 * @description: 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 *     对每个孩子i，都有一个胃口值g【i】，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干j，都有一个尺寸s【j】。如果
 *     s【j】》=g【i】，我们可以将这个饼干j分配给孩子i，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * @author: Sxuet
 * @create: 2021-09-30 13:25
 */
public class FindContentChildren455 {
  /**
   * 排序+双指针， 排序后再依次一个个分配 <br>
   * 执行用时： 7 ms , 在所有 Java 提交中击败了 99.71% 的用户 内存消耗： 39.3 MB , 在所有 Java 提交中击败了 25.09% 的用户
   *
   * @param g
   * @param s
   * @return
   */
  public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int i = 0, j = 0;
    while (i < g.length && j < s.length) {
      if (s[j] >= g[i]) {
        i++;
      }
      j++;
    }

    return i;
  }
}
