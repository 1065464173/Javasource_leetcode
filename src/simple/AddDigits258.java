package simple;

/**
 * @program: Javasource_leetcode
 * @description: 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数
 * @author: Sxuet
 * @create: 2021-08-17 11:33
 */
public class AddDigits258 {

  /**
   * 自创写法，如果所提供的参数大于等于10，就把他的每一位相加
   *
   * <p>执行用时： 2 ms , 在所有 Java 提交中击败了 10.32% 的用户 内存消耗： 35.8 MB , 在所有 Java 提交中击败了 6.65% 的用户
   *
   * @param num
   * @return
   */
  public int addDigits1(int num) {
    while (num >= 10) {
      String s = String.valueOf(num);
      int nextNum = 0;
      for (int i = 0; i < s.length(); i++) {
        nextNum += Integer.parseInt(String.valueOf(s.charAt(i)));
      }
      num = nextNum;
    }
    return num;
  }

  public int addDigits2(int num) {
    // TODO:数学果然美妙。。。

    // 数学公式推导  v= x*100+y*10+z*1 = x*99+y*9+x+y+z;
    // 处理0 和 9的问题
    if (num == 0) {
        return 0;
    }
    if (num % 9 == 0) {
        return 9;
    }
    return num % 9;
  }

  public int addDigits3(int num) {
    return (num - 1) % 9 + 1;
  }
}
