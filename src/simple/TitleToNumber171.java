package simple;

/**
 * @program: Javasource_leetcode
 * @description: 给定一个Excel表格中的列名称，返回其相应的列序号
 * @author: Sxuet
 * @create: 2021-07-25 21:08
 */
public class TitleToNumber171 {
  public static void main(String[] args) {
    int a = 'A';
    System.out.println(a);
  }

  /**
   * 自己写的 时间O(n) 空间O(1)<br>
   * 思路：a(26^n)*b(26^(n-1))*……*1 n为数组的长度
   *
   * @param columnTitle
   * @return
   */
  public int titleToNumber(String columnTitle) {
    char[] chars = columnTitle.toCharArray();
    int sum = 0;
    for (int i = 0; i < chars.length; i++) {
      int num = chars[i] - 'A' + 1;
      sum += (chars[i] - 'A' + 1) * (Math.pow(26, chars.length - i - 1));
    }
    return sum;
  }
}
