package simple;

import org.junit.jupiter.api.Test;

/**
 * @program: Javasource_leetcode
 * @description: 实现int sqrt(int x)函数。 计算并返回x的平方根，其中x 是非负整数。 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * @author: Sxuet
 * @create: 2021-07-01 19:43
 */
public class MySqrt69 {

  @Test
  public void test() {
    int i = mySqrt1(4);
    System.out.println(i);
  }

  /**
   * 二分查找
   *
   * @param x
   * @return
   */
  public int mySqrt1(int x) {
    if (x == 1) {
      return 1;
    }
    int min = 0;
    int max = x;
    while ((max - min) > 1) {
      int m = min + (max - min) / 2;
      // 用x/m<m而不是m*m>x防止溢出
      if (x / m < m) {
        max = m;
      } else {
        min = m;
      }
    }
    return min;
  }

  /**
   * 捷径式
   *
   * @param x
   * @return sqrt(x)
   */
  public int mySqrt2(int x) {
    return (int) Math.sqrt(x);
  }
}
