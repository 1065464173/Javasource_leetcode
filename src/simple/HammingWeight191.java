package simple;

/**
 * @program: Javasource_leetcode
 * @description: 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 *     <p>
 *     <p>提示：
 *     <p>请注意，在某些语言（如
 *     Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。 在
 *     Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的示例 3中，输入表示有符号整数 -3。
 * @author: Sxuet
 * @create: 2021-07-28 21:30
 */
public class HammingWeight191 {
  /**
   * 自己写的循环。遍历32次 时间O(n) 空间O(1)
   *
   * @param n
   * @return
   */
  public int hammingWeight1(int n) {
    int count = 0;
    for (int i = 0; i < 32; i++) {
      count += (n & 1) == 1 ? 1 : 0;
      n >>= 1;
    }
    return count;
  }

  /**
   * 位运算优化 n&(n-1)每次可以把n的最低位1变成0，如0b(10100)&(10011)=10000， 每舍掉一个1做一次计数，每次都与n-1进行与运算，直到n变成0 Brian
   * Kernighan Algorithm 布莱恩·克尼根算法
   *
   * <p>时间复杂度O(logn) 最坏情况下n的二进制位全为1，所以需要循环logn次 时间O(1)
   *
   * <p>可以思考一下lowbit()，也是求最低位1
   *
   * @param n
   * @return
   */
  public int hammingWeight2(int n) {
    int count = 0;
    // 在java里没有无符号的二进制数，所以不能while(n>0)
    while (n != 0) {
      n &= (n - 1);
      count++;
    }

    return count;
  }

  /**
   * lowbit 空间时间复杂度同上
   *
   * @param n
   * @return
   */
  public int hammingWeight3(int n) {
    int count = 0;
    while (n != 0) {
      // n -= n & -n;
      // -n=~n+1
      n -= n & (~n + 1);
      count++;
    }
    return count;
  }

  /**
   * 分组统计，时间空间复杂度O(1)! nb! 这是处理整数32位二进制数的情况下<br>
   * 如果处理更大的数，这个方法非常又用因为只有32位，该算法会产生多个中间结果，导致赋值发生多次，并且指令之间存在对n指数的依赖，可能不会被优化为并行指令
   * 这个道理和对于排序元素较少的情况下，我们选择选择排序，而不是归并排序是一样的
   *
   * <p>算法思想： 将二进制数分成两部分（分成奇数组合偶数组）， 分别求每个部分的的数目，然后再继续分，直到不能分为止，这时候每一个部分都只有一位bit， 这时候是一组对应一个bit
   * 第一次奇偶合并： (n>>1)&M1将二进制数全体右移1位然后&M1得到的是偶数组的数据 n&M1将二进制数直接&M1得到的是奇数组的数据 合并完后，每一组的数就代表着前两组1的数目的和
   *
   * @param n
   * @return
   */
  public int hammingWeight4(int n) {
    //    Integer.bitCount(n)的源码;
    // 计算奇数位和偶数位的1的总和
    n = (n & 0x55555555) + ((n >>> 1) & 0x55555555);
    n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
    n = (n & 0x0f0f0f0f) + ((n >>> 4) & 0x0f0f0f0f);
    //    n = (n & 0x00ff00ff) + ((n >>> 8) & 0x00ff00ff);
    //    n = (n & 0x0000ffff) + ((n >>> 16) & 0x0000ffff);
    //    return n;
    // 代码简化，不用合并到只剩一组，合并到剩4组时通过右移来将四组的数据加在一起就是最终答案
    n = n + (n >> 8);
    n = n + (n >> 16);
    // 0x3f对应00000000 00000000 00000000 11111111
    // &0x3f的意思是取出该二进制数的前八位
    return n & 0x3f;
  }
}
