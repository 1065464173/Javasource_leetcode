package simple;

/**
 * @program: Javasource_leetcode
 * @description: 猜数字游戏的规则如下：
 *     <p>每轮游戏，我都会从1到n 随机选择一个数字。 请你猜选出的是哪个数字。 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。 你可以通过调用一个预先定义好的接口
 *     int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1或 0）：
 *     <p>-1：我选出的数字比你猜的数字小 pick < num 1：我选出的数字比你猜的数字大 pick > num 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick ==
 *     num 返回我选出的数字。
 * @author: Sxuet
 * @create: 2021-09-05 19:46
 */
public class GuessNumber374 {
  /**
   * 二分查找<br>
   * 时间复杂度：O(logn)。空间复杂度：O（1）。
   *
   * @param n
   * @return
   */
  public int guessNumber(int n) {
    int left = 1, right = n;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (guess(mid) <= 0) {
        right = mid; // 答案在区间 [left, mid] 中
      } else {
        left = mid + 1; // 答案在区间 [mid+1, right] 中
      }
    }
    return left;
  }

  private int guess(int ans) {
    return 0;
  }
}
