package simple;

/**
 * @author Sxuet
 * @program Javasource_leetcode
 * @description 给你一个字符串s表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符： 'A' ： Absent，缺勤
 *     'L':Late，迟到'P'：Present，到场 如果学生能够同时满足下面两个条件，则可以获得出勤奖励： 按总出勤计，学生缺勤（'A’）严格少于两天。
 *     学生不会存在连续3天或连续3天以上的迟到（‘L’）记录。 如果学生可以获得出勤奖励，返回true；否则，返回false。
 * @since 2021-11-08 10:31
 */
public class CheckRecord551 {
  /**
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 36.3 MB , 在所有 Java 提交中击败了 78.84% 的用户
   *
   * @param s
   * @return
   */
  public boolean checkRecord1(String s) {
    int absent = 0;
    int late = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if ('A' == c) {
        absent++;
        late = 0;
      } else if ('L' == c) {
        late++;
      } else {
        late = 0;
      }
      if (absent >= 2 || late >= 3) {
        return false;
      }
    }
    return true;
  }

  /**
   * 评论区一个神奇的解法(脑洞大开)<br>
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 36.2 MB , 在所有 Java 提交中击败了 89.50% 的用户
   *
   * @param s
   * @return
   */
  public boolean checkRecord2(String s) {
    return (s.indexOf('A') == s.lastIndexOf('A')) && (!s.contains("LLL"));
  }
}
