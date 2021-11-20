package medium;

/**
 * @author Sxuet
 * @program daydayup
 * @description ” 给定一个数字，我们按照如下规则把它翻译为字符串：0翻译成“a”1翻译成 “口，，田田 .J 11翻译成“1”，
 *     25翻译成“z”。一个数字可能有多个翻译。请编程实现一个函数，用 来计算一个数字有多少种不同的翻译方法。
 * @since 2021-11-19 16:12
 */
public class TranslateNum46 {
  /**
   * 动态规划： <br>
   * 1. 划分问题：判断有多少种翻译方法->有多少种1-25的数字组合方式->少一位数字的组合方式+1活+2<br>
   * 2. 定义问题与状态之间的关系:F(n) = F(n/10)+(n<2?2:1)<br>
   * 3. 记录解的个数 <br>
   * 官方解析<br>
   * 定义状态：dp【i】表示nums【0..i】能翻译成字符串的种类数； <br>
   * 状态转移方程：dp【i】=dp【i-1】+dp【i-2】（如果nums【（i-1）..i】可以翻译） <br>
   * 初始化：dp【0】=1（0-9各自可以翻译成1种结果）<br>
   * 输出：dp【len-1】； <br>
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 35.1 MB , 在所有 Java 提交中击败了 75.03% 的用户
   *
   * @param num
   * @return
   */
  public int translateNum(int num) {
    String src = String.valueOf(num);
    int p = 0, q = 1, r = 1;
    for (int i = 1; i < src.length(); ++i) {
      p = q;
      q = r;
      String pre = src.substring(i - 1, i + 1);
      if (pre.compareTo("25") <= 0 && pre.compareTo("10") >= 0) {
        r = p + q;
      }
    }
    return r;
  }
}
