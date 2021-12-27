package simple;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Sxuet
 * @program daydayup
 * @description
 *     从若干副扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2~10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为0，可以看成任意数字。A不能视为14。
 * @since 2021-11-25 09:51
 */
public class IsStraight61 {
  /**
   * 执行用时： 1 ms , 在所有 Java 提交中击败了 42.23% 的用户 内存消耗： 35.9 MB , 在所有 Java 提交中击败了 22.88% 的用户
   *
   * @param nums
   * @return
   */
  public boolean isStraight(int[] nums) {
    Set<Integer> repeat = new HashSet<>();
    int max = 0, min = 14;
    for (int num : nums) {
      // 跳过大小王
      if (num == 0) {
          continue;
      }
      // 最大牌
      max = Math.max(max, num);
      // 最小牌
      min = Math.min(min, num);
      // 若有重复，提前返回 false
      if (repeat.contains(num)) {
          return false;
      }
      // 添加此牌至 Set
      repeat.add(num);
    }
    // 最大牌 - 最小牌 < 5 则可构成顺子
    return max - min < 5;
  }

  /**
   * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 36.1 MB , 在所有 Java 提交中击败了 5.26% 的用户
   *
   * @param nums
   * @return
   */
  public boolean isStraight2(int[] nums) {
    int joker = 0;
    // 数组排序
    Arrays.sort(nums);
    for (int i = 0; i < 4; i++) {
      // 统计大小王数量
      if (nums[i] == 0) {
          joker++;
      }
      // 若有重复，提前返回 false
      else if (nums[i] == nums[i + 1]) {
          return false;
      }
    }
    // 最大牌 - 最小牌 < 5 则可构成顺子
    return nums[4] - nums[joker] < 5;
  }
}
