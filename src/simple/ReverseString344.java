package simple;

/**
 * @program: Javasource_leetcode
 * @description: 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *     <p>不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *     <p>你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * @author: Sxuet
 * @create: 2021-08-30 20:53
 */
public class ReverseString344 {
  /**
   * 太简单了，索然无味<br>
   * 时间O(n/2) 空间O(1)<br>
   * 执行用时： 1 ms , 在所有 Java 提交中击败了 96.78% 的用户 内存消耗： 45 MB , 在所有 Java 提交中击败了 52.92% 的用户
   *
   * @param s
   */
  public void reverseString1(char[] s) {
    for (int i = 0; i < s.length / 2; i++) {
      char temp = s[i];
      s[i] = s[s.length - 1 - i];
      s[s.length - 1 - i] = temp;
    }
  }
}
