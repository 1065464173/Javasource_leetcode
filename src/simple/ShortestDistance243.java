package simple;

/**
 * @program: Javasource_leetcode
 * @description:
 * @author: Sxuet
 * @create: 2021-08-13 09:42
 */
public class ShortestDistance243 {
  /**
   * 暴力解法，遍历两次，找到两个遍历 返回距离的最小值<br>
   * 时间复杂度O(n^2) 空间O(1)<br>
   * 执行用时： 2 ms , 在所有 Java 提交中击败了 90.25% 的用户 内存消耗： 38.5 MB , 在所有 Java 提交中击败了 40.75% 的用户
   *
   * @param wordsDict
   * @param word1
   * @param word2
   * @return
   */
  public int shortestDistance1(String[] wordsDict, String word1, String word2) {
    int minDistance = wordsDict.length;
    for (int i = 0; i < wordsDict.length; i++) {
      if (wordsDict[i].equals(word1)) {
        for (int j = 0; j < wordsDict.length; j++) {
          if (wordsDict[j].equals(word2)) {
            minDistance = Math.min(minDistance, Math.abs(j - i));
          }
        }
      }
    }
    return minDistance;
  }

  /**
   * 遍历一次 时间复杂符O(1)
   *
   * <p>记录两个下标 i1 和 i2 来显著提高暴力的时间复杂度，我们保存 word1 和 word2 的 最近
   * 出现位置。每次我们发现一个新的单词出现位置，我们不需要遍历整个数组去找到另一个单词，因为我们已经记录了最近出现位置的下标。<br>
   * 执行用时： 2 ms , 在所有 Java 提交中击败了 90.25% 的用户 内存消耗： 38.2 MB , 在所有 Java 提交中击败了 90.00% 的用户
   *
   * @param wordsDict
   * @param word1
   * @param word2
   * @return
   */
  public int shortestDistance2(String[] wordsDict, String word1, String word2) {
    int minDistance = wordsDict.length, i1 = -1, i2 = -1;
    for (int i = 0; i < wordsDict.length; i++) {
      if (wordsDict[i].equals(word1)) {
        i1 = i;
      } else if (wordsDict[i].equals(word2)) {
        i2 = i;
      }
      if (i1 != -1 && i2 != -1) {
        minDistance = Math.min(minDistance, Math.abs(i1 - i2));
      }
    }
    return minDistance;
  }
}
