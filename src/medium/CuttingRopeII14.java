package medium;

/**
 * @author Sxuet
 * @program daydayup
 * @description
 *     给你一根长度为n的绳子，请把绳子剪成整数长度的m段（m、n都是整数，n》1并且m》1），每段绳子的长度记为k【0】，k【1】...k【m1】。请问k【0】*k【1】*...*k【m-1】可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *     答案需要取模1e9+7（1000000007），如计算初始结果为：1000000008，请返回1。
 * @since 2021-12-10 11:12
 */

public class CuttingRopeII14 {
  /**
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 35.4 MB , 在所有 Java 提交中击败了 14.96% 的用户
   *
   * @param n
   * @return
   */
  public int cuttingRope1(int n) {
    if(n <= 3) {
      return n - 1;
    }
    long res=1L;
    int p=(int)1e9+7;
    //贪心算法，优先切三，其次切二
    while(n>4){
      res=res*3%p;
      n-=3;
    }
    //出来循环只有三种情况，分别是n=2、3、4
    return (int)(res*n%p);
  }

  /**
   * K神精选<br>
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 35.1 MB , 在所有 Java 提交中击败了 69.60% 的用户
   *
   * @param n
   * @return
   */
  public int cuttingRope2(int n) {
    if(n <= 3) {
      return n - 1;
    }
    int ans = 1;
    int b = n % 3, p = 1000000007;
    long rem = 1, x = 3;
    for(int a = n / 3 - 1; a > 0; a /= 2) {
      if(a % 2 == 1) {
        rem = (rem * x) % p;
      }
      x = (x * x) % p;
    }
    if(b == 0) return (int)(rem * 3 % p);
    if(b == 1) return (int)(rem * 4 % p);
    return (int)(rem * 6 % p);
  }
}
