package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sxuet
 * @program daydayup
 * @description 在一个数组nums中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * @since 2021-12-01 14:27
 */
public class SingleNumber56 {
  /**
   * hashmap...面试写这个会被淘汰吧？
   *
   * @param nums
   * @return
   */
  public int singleNumber1(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() == 1) {
        return entry.getKey();
      }
    }
    return 0;
  }

  /**
   * K神的位运算已经把我整懵了 ^_^呵呵 <br>
   * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 39.3 MB , 在所有 Java 提交中击败了 61.58% 的用户
   *
   * @param nums
   * @return
   */
  public int singleNumber2(int[] nums) {
    int ones = 0, twos = 0;
    for (int num : nums) {
      ones = ones ^ num & ~twos;
      twos = twos ^ num & ~ones;
    }
    return ones;
  }

  /**
   * 复习了一遍卡诺图，终于！看懂了！！！！！！！！！！ <br>
   * 执行用时： 2 ms , 在所有 Java 提交中击败了 84.60% 的用户 内存消耗： 39.5 MB , 在所有 Java 提交中击败了 32.26% 的用户
   *
   * @param nums
   * @return
   */
  public int singleNumber3(int[] nums) {
    // 可以设计一种逻辑，使数字出现 3 次时，该逻辑的结果为 0（即只有 0，1，2 三种状态）
    // 其实就是一个 三进制
    // 一位二进制数只能存储 0 和 1 两种状态，所以我们需要用到两位二进制
    // 设两位二进制数的高位为 A，低位为 B。C 是输入变量
    // 表示的三种情况为 ： 0次：00(A=0,B=0), 1次：01(A=0,B=1), 2次：10(A=1,B=0)
    // 注：11(A=1,B=1) 为无效输入

    // 画出关于 A 的卡诺图（AB为11的结果是不重要的，用 x 表示）：
    //  AB\C |  0  |  1
    //  =================
    //    00 |  0  |  0
    //    01 |  0  |  1        ====> 得到 A = BC + AC'
    //    11 |  x  |  x
    //    10 |  1  |  0

    //  画出关于 B 的卡诺图
    //  AB\C |  0  |  1
    //  =================
    //    00 |  0  |  1
    //    01 |  1  |  0        ====> 得到 B = BC' + A'B'C
    //    11 |  x  |  x
    //    10 |  0  |  0

    // 很明显啊，我们需要的就是只出现一次的情况 01（A=0，B=1），即 B 的结果
    int A = 0, B = 0;
    for (int C : nums) {
      int tmp = A;
      A = (B & C) | (A & ~C);
      B = (B & ~C) | (~tmp & ~B & C);
    }
    return B;
  }
}
