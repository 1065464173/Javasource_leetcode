package simple;

import java.util.Arrays;

/**
 * @author Sxuet
 * @program Javasource_leetcode
 * @description 给出N名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予“金牌”，“银牌”和“铜牌”（"Gold Medal", "Silver
 *     Medal", "Bronze Medal")。 （注：分数越高的选手，排名越靠前。） 1.N是一个正整数并且不会超过10000。 2.所有运动员的成绩都不相同。
 * @since 2021-10-27 14:56
 */
public class FindRelativeRanks506 {
  public String[] findRelativeRanks(int[] score) {
    int n = score.length;
    String[] ans = new String[n];
    int[] clone = Arrays.copyOf(score, n); // 复制score数组并进行排序
    Arrays.sort(clone);
    for (int i = 0; i < score.length; i++) {
      int rank = n - Arrays.binarySearch(clone, score[i]); // n - 排序后的下标 == 名次
      if (rank == 1) ans[i] = "Gold Medal";
      else if (rank == 2) ans[i] = "Silver Medal";
      else if (rank == 3) ans[i] = "Bronze Medal";
      else ans[i] = Integer.toString(rank);
    }
    return ans;
  }
}
