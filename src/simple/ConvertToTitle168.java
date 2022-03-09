package simple;

/**
 * @program: Javasource_leetcode
 * @description: 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称
 * @author: Sxuet
 * @create: 2021-07-22 22:28
 */
public class ConvertToTitle168 {
  /**
   * 可以看作26进制转换 需要不断地对 columnNumber 进行 % 运算取得最后一位，
   *
   * <p>然后对 columnNumber 进行 / 运算，将已经取得的位数去掉，直到 columnNumber 为 0 即可。
   *
   * <p>但本题需要我们将从 1 开始，因此在执行「进制转换」操作前，我们需要先对columnNumber 执行减一操作，从而实现整体偏移。
   *
   * <p>时间复杂度O(log26cn) 空间1
   *
   * @param columnNumber
   * @return
   */
  public String convertToTitle(int columnNumber) {
    int n = columnNumber;
    StringBuilder sb = new StringBuilder();
    while (n > 0) {
      int temp = (n - 1) % 26 + 1;
      sb.append((char) (temp - 1 + 'A'));
      n = (n - temp) / 26;
    }
    return sb.reverse().toString();
  }

  /**
   * 一个相对好理解的版本
   *
   * @param columnNumber
   * @return
   */
  public String convertToTitle1(int columnNumber) {
    StringBuilder sb = new StringBuilder();
    while (columnNumber > 0) {
      int remainder = columnNumber % 26;
      // 如果余数是0，就像上一位借个1（26）出来，让余数强行等于26
      if (remainder == 0) {
        remainder = 26;
        columnNumber -= 26;
      }
      sb.append((char) (remainder + 64));
      columnNumber /= 26;
    }

    return sb.reverse().toString();
  }
}
