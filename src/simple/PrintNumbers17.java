package simple;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author Sxuet
 * @program daydayup
 * @description 输入数字n，按顺序打印出从1到最大的n位十进制数。比如输入3，则打印出1、2、3一直到最大的3位数999。
 * @since 2021-12-09 16:08
 */
public class PrintNumbers17 {
  public int[] printNumbers1(int n) {
    int num = (int) Math.pow(10, n) - 1;
    int[] ans = new int[num];
    for (int i = 0; i < num; i++) {
      ans[i] = i + 1;
    }
    return ans;
  }

}
