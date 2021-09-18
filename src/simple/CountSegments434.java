package simple;

/**
 * @program: Javasource_leetcode
 * @description:
 * @author: Sxuet
 * @create: 2021-09-18 20:12
 */
public class CountSegments434 {

  /**
   * 使用正则表达式分开每个单词并计算 需要处理边缘数据<br>
   * 时间复杂度：O（n）；空间复杂度：O（n） <br>
   * 执行用时： 2 ms , 在所有 Java 提交中击败了 28.78% 的用户 内存消耗： 36.3 MB , 在所有 Java 提交中击败了 34.08% 的用户
   *
   * @param s
   * @return
   */
  public static int countSegments1(String s) {
    String trimmed = s.trim();
    if (trimmed.equals("")) {
      return 0;
    }
    return trimmed.split("\\s+").length;
  }

  /**
   * 原地计数法<br>
   * 计算单词的数量，就等同于计数单词开始的下标个数 <br>
   * 时间复杂度：0（n）。 对每个下标进行常数时间的检测。 空间复杂度：O（1）。 只使用了额外的几个整数，因此使用的空间为常数。 <br>
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 36 MB , 在所有 Java 提交中击败了 84.26% 的用户
   *
   * @param s
   * @return
   */
  public static int countSegments2(String s) {

    int segmentCount = 0;
    for (int i = 0; i < s.length(); i++) {
      if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
        segmentCount++;
      }
    }
    return segmentCount;
  }
}
