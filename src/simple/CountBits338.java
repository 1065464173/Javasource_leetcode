package simple;

/**
 * @program: Javasource_leetcode
 * @description: 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * @author: Sxuet
 * @create: 2021-08-28 22:37
 */
public class CountBits338 {
  /**
   * 自己写的最简单的迭代求值 计算1的个数使用的是Integer.bitCount <br>
   * 时间 O(n*sizeof(integer)) 空间O(1)<br>
   * 执行用时： 2 ms , 在所有 Java 提交中击败了 54.24% 的用户 内存消耗： 42.4 MB , 在所有 Java 提交中击败了 60.66% 的用户
   *
   * @param n
   * @return
   */
  public int[] countBits1(int n) {
    int[] res = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      res[i] = Integer.bitCount(i);
    }
    return res;
  }

  /**
   * 动态规划——最高有效位 时间O(n) 空间O(1) <br>
   *
   * <p>当计算 i 的「一比特数」时，如果存在 0≤j<i， j 的「一比特数」已知，且 i 和 j 相比， i 的二进制表示只多了一个 1 则可以快速得到 i 的「一比特数 <br>
   * 内存消耗： 42.2 MB , 在所有 Java 提交中击败了 83.81% 的用户
   *
   * @param n
   * @return
   */
  public int[] countBits2(int n) {
    int[] bits = new int[n + 1];
    int highBit = 0;
    // 从1开始遍历，默认bits[0]=0
    for (int i = 1; i <= n; i++) {
      // 如果i & (i - 1)) == 0，则i为2的整数次幂——最高位为1，其余为0
      if ((i & (i - 1)) == 0) {
        highBit = i;
      }
      bits[i] = bits[i - highBit] + 1;
    }
    return bits;
  }

  /**
   * 动态规划——最低有效位 时间O(n) 空间O(1)
   *
   * <p>方法二需要实时维护最高有效位，当遍历到的数是 2 的整数次幂时，需要更新最高有效位。如果再换一个思路，可以使用「最低有效位」计算「一比特数」。 <br>
   * * 如果x是偶数，则 bits[x]=bits[⌊x/2⌋]； 如果x是奇数，则 bits[x]=bits[⌊x/2⌋]+1。
   *
   * @param n
   * @return
   */
  public int[] countBits3(int n) {
    int[] bits = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      bits[i] = bits[i >> 1] + (i & 1);
    }
    return bits;
  }

  /**
   * 动态规划——最低设置位 时间O(n) 空间O(1)
   *
   * <p>定义正整数 x 的「最低设置位」为 x 的二进制表示中的最低的 1 所在位。例如， 10 的二进制表示是 1010 ，其最低设置位为 2，对应的二进制表示是 10 <br>
   *
   * @param n
   * @return
   */
  public int[] countBits4(int n) {
    int[] bits = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      bits[i] = bits[i & (i - 1)] + 1;
    }
    return bits;
  }
}
