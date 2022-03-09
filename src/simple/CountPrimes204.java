package simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: Javasource_leetcode
 * @description: 统计所有小于非负整数 n 的质数的数量。
 * @author: Sxuet
 * @create: 2021-07-30 21:23
 */
public class CountPrimes204 {

  /**
   * 枚举 判断每个数是否是质数，每个数判断需要sqrt(n)次
   *
   * <p>时间复杂度O(n*sqrt(n)）次 空间O(1) 超出时间限制
   *
   * @param n
   * @return
   */
  public int countPrimes1(int n) {

    int ans = 0;
    for (int i = 2; i < n; ++i) {
      ans += isPrime(i) ? 1 : 0;
    }
    return ans;
  }

  public boolean isPrime(int x) {
    for (int i = 2; i * i <= x; ++i) {
      if (x % i == 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * 厄拉多塞筛法，简称埃氏筛
   *
   * <p>如果x 是质数，那么大于x 的x 的倍数2x,3x,… 一定不是质数。 优化： 可以直接从x*x入手，因为2x，3x其实是冗余的，早是2的倍数，3的倍数了
   *
   * <p>时间O(nloglogn) 空间O(n)
   *
   * @param n
   * @return
   */
  public int countPrimes2(int n) {
    int[] isPrime = new int[n];
    Arrays.fill(isPrime, 1);
    int ans = 0;
    for (int i = 2; i < n; i++) {
      if (isPrime[i] == 1) {
        ans++;
      }
      if ((long) i * i < n) {
        for (int j = i * i; j < n; j += i) {
          isPrime[j] = 0;
        }
      }
    }
    return ans;
  }

  /**
   * 线性筛——厄拉多塞筛法的优化，将每个合数被标记的次数降为1 相较于埃氏筛，我们多维护一个 primes 数组表示当前得到的质数集合。我们从小到大遍历，如果当前的数 x x 是质数，就将其加入
   * primes 数组 另一点与埃氏筛不同的是，「标记过程」不再仅当 x 为质数时才进行，而是对每个整数 x 都进行。对于整数 x，我们不再标记其所有的倍数
   * x⋅x,x⋅(x+1),…，而是只标记质数集合中的数与 x 相乘的数，即 x⋅primes 0 ,x⋅primes 1,…，且在发现 x mod primes i = 0
   * 的时候结束当前标记。
   *
   * @param n
   * @return
   */
  public int countPrimes3(int n) {
    List<Integer> primes = new ArrayList<Integer>();
    int[] isPrime = new int[n];
    Arrays.fill(isPrime, 1);
    for (int i = 2; i < n; ++i) {
      if (isPrime[i] == 1) {
        primes.add(i);
      }
      for (int j = 0; j < primes.size() && i * primes.get(j) < n; ++j) {
        isPrime[i * primes.get(j)] = 0;
        if (i % primes.get(j) == 0) {
          break;
        }
      }
    }
    return primes.size();
  }
}
