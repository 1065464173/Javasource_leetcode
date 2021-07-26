package simple;

/**
 * @Author: Sxuet @Date: 2021-06-04 14:38:28 @LastEditTime: 2021-06-04 21:24:24 @LastEditors:
 * Sxuet @FilePath: /JavaSE_learning/Javasource_leetcode/isPalindrome9.java @Description: 给你一个整数 x
 * ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 */
public class IsPalindrome9 {
  public static void main(String[] args) {
    System.out.println(isPalindrome1(-123321));
  }

  public static boolean isPalindrome1(int x) {
    String s = Integer.toString(x);
    String sub1 = null;
    String sub2 = null;
    if (x < 0 || (x % 10 == 0 && x != 0)) {
      return false;
    }
    if (s.length() % 2 == 1) {
      sub1 = s.substring(0, s.length() / 2);
      sub2 = s.substring(s.length() / 2 + 1, s.length());
    }
    if (s.length() % 2 == 0) {
      sub1 = s.substring(0, s.length() / 2);
      sub2 = s.substring(s.length() / 2, s.length());
    }
    sub2 = new StringBuffer(sub2).reverse().toString();
    return sub1.equals(sub2);
  }

  public boolean isPalindrome2(int x) {
    // 特殊情况：
    // 如上所述，当 x < 0 时，x 不是回文数。
    // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
    // 则其第一位数字也应该是 0
    // 只有 0 满足这一属性
    if (x < 0 || (x % 10 == 0 && x != 0)) {
      return false;
    }

    int revertedNumber = 0;
    while (x > revertedNumber) {
      revertedNumber = revertedNumber * 10 + x % 10;
      x /= 10;
    }

    // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
    // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
    // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
    return x == revertedNumber || x == revertedNumber / 10;
  }
}
