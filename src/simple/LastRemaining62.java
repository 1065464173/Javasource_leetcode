package simple;

/**
 * @author Sxuet
 * @program daydayup
 * @description 0，1，…，门-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
 *     例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * @since 2021-12-03 13:45
 */
public class LastRemaining62 {
  /**
   * 执行用时： 4 ms , 在所有 Java 提交中击败了 99.96% 的用户 内存消耗： 35.1 MB , 在所有 Java 提交中击败了 77.80% 的用户
   *
   * @param n
   * @param m
   * @return
   */
  public int lastRemaining(int n, int m) {
    // 色列夫环公式：f(N,M)=(f(N−1,M)+M)%N
    int p = 0;
    for (int i = 2; i <= n; i++) {
      p = (p + m) % i;
    }
    return p + 1;
  }
}
