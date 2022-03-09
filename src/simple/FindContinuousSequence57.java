package simple;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Sxuet
 * @program daydayup
 * @description 输入一个正整数target，输出所有和为target的连续正整数序列（至少含有两个数）。 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * @since 2021-12-03 10:52
 */
public class FindContinuousSequence57 {
  /** 我的枚举+数字=拉垮 至少是做出来了 T——T */
  public int[][] findContinuousSequence1(int target) {
    List<int[]> vec = new ArrayList<>();
    // target = n * a1 + n * ( n - 1 ) * d / 2; 已知target，d=1，求所有可能的n、a1
    // n ^ 2 + n ( 2a1 - 1 ) - 2target = 0
    for (int a1 = 1; a1 <= target >> 1; a1++) {
      double n = hasSolution(a1, target);
      // 如果n是整数则记录——n为数字的个数，必须为整数
      if (n % 1 == 0 && n > 0) {
        int[] temp = new int[(int) n];
        for (int i = 0, j = a1; i < n; i++, j++) {
          temp[i] = j;
        }
        vec.add(temp);
      }
    }
    return vec.toArray(new int[vec.size()][]);
  }

  private double hasSolution(int a1, int target) {
    // delta = b^2 - 4ac = (2 * a1 - 1) ^ 2 - 4 * 1 * 2 * target
    double b = 2 * a1 - 1;
    double delta = Math.pow(b, 2) + 8 * target;
    // delta 小于0 没有解，大于等于0有解。设定没有解时返回-1
    if (delta < 0) {
      return -1;
    }
    return (-b + Math.sqrt(delta)) / 2;
  }

  /**
   * 官方的暴力枚举法 <br>
   * 执行用时： 3 ms , 在所有 Java 提交中击败了 49.48% 的用户 内存消耗： 36.4 MB , 在所有 Java 提交中击败了 65.35% 的用户
   *
   * @param target
   * @return
   */
  public int[][] findContinuousSequence2(int target) {
    List<int[]> vec = new ArrayList<int[]>();
    // (target - 1) / 2 等效于 target / 2 下取整
    int sum = 0, limit = (target - 1) / 2;
    for (int i = 1; i <= limit; ++i) {
      for (int j = i; ; ++j) {
        sum += j;
        if (sum > target) {
          sum = 0;
          break;
        } else if (sum == target) {
          int[] res = new int[j - i + 1];
          for (int k = i; k <= j; ++k) {
            res[k - i] = k;
          }
          vec.add(res);
          sum = 0;
          break;
        }
      }
    }
    return vec.toArray(new int[vec.size()][]);
  }

  /**
   * 官方的枚举+数学优化
   *
   * @param target
   * @return
   */
  public int[][] findContinuousSequence(int target) {
    List<int[]> vec = new ArrayList<>();
    int sum = 0, limit = (target - 1) / 2;
    for (int x = 1; x <= limit; ++x) {
      long delta = 1 - 4 * (x - (long) x * x - 2 * target);
      if (delta < 0) {
        continue;
      }
      int delta_sqrt = (int) Math.sqrt(delta + 0.5);
      if ((long) delta_sqrt * delta_sqrt == delta && (delta_sqrt - 1) % 2 == 0) {
        // 另一个解(-1-delta_sqrt)/2必然小于0，不用考虑
        int y = (-1 + delta_sqrt) / 2;
        if (x < y) {
          int[] res = new int[y - x + 1];
          for (int i = x; i <= y; ++i) {
            res[i - x] = i;
          }
          vec.add(res);
        }
      }
    }
    return vec.toArray(new int[vec.size()][]);
  }

  /**
   * 评论区的滑动窗口，赞！ <br>
   * 执行用时： 2 ms , 在所有 Java 提交中击败了 97.23% 的用户 内存消耗： 36.3 MB , 在所有 Java 提交中击败了 74.80% 的用户
   *
   * @param target
   * @return
   */
  public int[][] findContinuousSequence3(int target) {
    List<int[]> res = new ArrayList<>();
    // 滑动窗口左边界
    int left = 1;
    // 滑动窗口右边界
    int right = 1;
    // 滑动窗口内序列的和
    int sum = 0;
    while (left <= target / 2) {
      // sum<target,右边界向右移动
      if (sum < target) {
        sum += right;
        right++;
      }
      // sum>target,左边界向右移动
      else if (sum > target) {
        sum -= left;
        left++;
      }
      // 满足条件了sum=target
      else {
        int[] array = new int[right - left];
        for (int i = 0; i < (right - left); i++) {
          array[i] = left + i;
        }
        res.add(array);
        sum -= left;
        // 左边界右移
        left++;
      }
    }
    return res.toArray(new int[res.size()][]);
  }
}
