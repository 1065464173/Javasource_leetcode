package simple;

/**
 * @program: Javasource_leetcode
 * @description: 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 注意：给定 n 是一个正整数。
 *     https://leetcode-cn.com/problems/climbing-stairs/solution/pa-lou-ti-by-leetcode-solution/
 * @author: Sxuet
 * @create: 2021-07-02 14:45
 */
public class ClimbStairs70 {

  /**
   * 斐波那契数列：fn = f(n-1)+f(n-2) 使用斐波那契数列的通项公式即可 时间复杂度取决于Math内部算法，double转int会缺少部分精度
   *
   * @param n
   * @return
   */
  public int climbStairs3(int n) {
    double sqrt_5 = Math.sqrt(5);
    double fib_n = Math.pow((1 + sqrt_5) / 2, n + 1) - Math.pow((1 - sqrt_5) / 2, n + 1);
    return (int) (fib_n / sqrt_5);
  }

  /**
   * 爬n阶楼梯和n-1 层的爬法有关， 第n-1个台阶的走法 + 第n-2个台阶的走法 = 到第n个台阶的走法 故用动态规划 此方法超出运行时间 时间复杂度和空间复杂度都是 O ( n )
   * O(n) 的实现 时间复杂度是 O ( 2^n )，存在很多冗余计算。 F n ​ =1/ 5 ​ [( 2 1+ 5 ​
   *
   * @param n
   * @return
   */
  public int climbStairs1(int n) {
    if (n == 1) {
      return 1;
    } else if (n == 2) {
      return 2;
    } else if (n < 1) {
      return 0;
    }
    return climbStairs1(n - 1) + climbStairs1(n - 2);
  }

  /**
   * 因为fn只和fn-1、fn-2相关，所以用动态滑动的方式将空间复杂符降为O(1),时间复杂度O(n)
   *
   * @param n
   * @return
   */
  public int climbStairs2(int n) {
    int p = 0, q = 0, r = 1;
    for (int i = 0; i < n; i++) {
      p = q;
      q = r;
      r = p + q;
    }
    return r;
  }
}
