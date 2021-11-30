package medium;

/**
 * @author Sxuet
 * @program daydayup
 * @description 求1+2+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A？B：C）。
 * @since 2021-11-28 15:15
 */
public class SumNums64 {
  public int sum = 0;

  /**
   * 自己写的
   *
   * @param n
   * @return
   */
  public int sumNums1(int n) {
    if (n > 0) {
      sum += n;
      sumNums1(n - 1);
      return sum;
    }
    return 0;
  }

  /**
   * 官方写的
   *
   * @param n
   * @return
   */
  public int sumNums2(int n) {
    boolean flag = n > 0 && (n += sumNums2(n - 1)) > 0;
    return n;
  }

  /**
   * yyds!
   *
   * @param n
   * @return
   */
  public int sumNums3(int n) {
    return n * (n + 1) >> 1;
  }
}
