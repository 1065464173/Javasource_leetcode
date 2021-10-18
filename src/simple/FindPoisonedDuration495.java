package simple;

/**
 * @program: Javasource_leetcode
 * @description:
 *     在《英雄联盟》的世界中，有一个叫“提莫”的英雄，他的攻击可以让敌方英雄艾希（编者注：寒冰射手）进入中毒状态。现在，给出提莫对艾希的攻击时间序列和提莫攻击的中毒持续时间，你需要输出艾希的中毒状态总时长。
 *     你可以认为提莫在给定的时间点进行攻击，并立即使艾希处于中毒状态。
 * @author: Sxuet
 * @create: 2021-10-18 10:38
 */
public class FindPoisonedDuration495 {
  /**
   * 遍历一遍 计算平a时间之间的差值，如果差值小于中毒持续时间，则中毒时间加上差值 <br>
   * 执行用时： 2 ms , 在所有 Java 提交中击败了 91.69% 的用户 内存消耗： 39.8 MB , 在所有 Java 提交中击败了 94.62% 的用户
   *
   * @param timeSeries - 攻击时间集合
   * @param duration - 中毒持续时间
   * @return 总中毒时间
   */
  public int findPoisonedDuration(int[] timeSeries, int duration) {
    int ans = 0;
    for (int i = 1; i < timeSeries.length; i++) {
      ans += Math.min(timeSeries[i] - timeSeries[i - 1], duration);
    }
    return ans + duration;
  }
}
